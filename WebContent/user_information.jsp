<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.io.*,javax.servlet.*,javax.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資料</title>
</head>
<style type="text/css">
		body{
			width:30%;
			margin: auto;
		}

    	div {		
		border-style:double hidden;
		border-width: 3px;
		border-color: orange;
		
    	}
			
    </style>
<body>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs;

request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");



String id=(String)session.getAttribute("ID");

String sDriver ="org.mariadb.jdbc.Driver";
String url ="jdbc:mariadb://localhost/rest";

Class.forName(sDriver);
con = DriverManager.getConnection(url,"root","1234");
stmt = con.createStatement();

String str="select * from user where id ='"+id+"'";
rs=stmt.executeQuery(str);

while(rs.next()){
	
	session.setAttribute("password", rs.getString("password"));
	session.setAttribute("name", rs.getString("name"));
	session.setAttribute("gender", rs.getString("gender"));
	session.setAttribute("birthday", rs.getString("birthday"));
	session.setAttribute("tel", rs.getString("tel"));
	session.setAttribute("email", rs.getString("email"));
}

   
   String getpw=(String)session.getAttribute("password");
   String getname=(String)session.getAttribute("name");
   String getgender=(String)session.getAttribute("gender");
   String getbirthday=(String)session.getAttribute("birthday");
   String gettel=(String)session.getAttribute("tel");
   String getemail=(String)session.getAttribute("email");
   session.setAttribute("ID",id);

   System.out.println(getname);

%>
<%if(session.getAttribute("ID")==null){ 
%><script>alert('請登入帳號密碼');window.location.href='Login.html'</script><%} %>
<h2>基本資料</h2>
    <form name="userform" method="post" action="user_information2.jsp">  
      <div>
        <p>
        <label style='color:red'>*:必須輸入</label><p>
        
        *帳號 ：<input type="text" name="id" size=12 value="<%=id%>" disabled="disabled"><p>
        *密碼 ：<input type="password" name="pw" size=8 value="<%=getpw%>" disabled="disabled"><p>
        *姓名：<input type="text" name="user" size=14 value="<%=getname%>" disabled="disabled"><p> 
        *性別：<input type="text" name="gender" value="<%=getgender%>" disabled="disabled"><p>
             
        *生日：<input type="date" name="birthday" value="<%=getbirthday%>" disabled="disabled"><p>
        *電話：<input type="tel" name="tel" size=14 value="<%=gettel%>" disabled="disabled"><p>
        *電子信箱：<input type="email" name="email" size=30 value="<%=getemail%>" disabled="disabled"><p>
		
      </div>
      <br><input type="submit" value="修改資料">
      <input type="button" id="btn" name="back" value="回首頁" onclick="javascript:location.href='onepage.jsp'">
      
           
    </form>

</body>
</html>