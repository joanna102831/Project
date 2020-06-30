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

String str="select * from restaurant where id ='"+id+"'";
rs=stmt.executeQuery(str);

while(rs.next()){
	
	session.setAttribute("password", rs.getString("password"));
	session.setAttribute("restname", rs.getString("restname"));
	session.setAttribute("people", rs.getString("total_people"));
	session.setAttribute("tel", rs.getString("tel"));
	
}

   
   String getpw=(String)session.getAttribute("password");
   String getname=(String)session.getAttribute("restname");
   String getpeople=(String)session.getAttribute("people");
   String gettel=(String)session.getAttribute("tel");
   session.setAttribute("ID",id);


%>
<%if(session.getAttribute("ID")==null){ 
%><script>alert('請登入帳號密碼');window.location.href='Login_rest.html'</script><%} %>
<h2>基本資料</h2>
    <form name="userform" method="post" action="rest_information2.jsp">  
      <div>
        <p>
        <label style='color:red'>*:必須輸入</label><p>
        
        *帳號 ：<input type="text" name="id" size=12 value="<%=id%>" disabled="disabled"><p>
        *密碼 ：<input type="password" name="pw" size=8 value="<%=getpw%>" disabled="disabled"><p>
        *餐廳名稱：<input type="text" name="restname" size=14 value="<%=getname%>" disabled="disabled"><p> 
        *人數：<input type="number" name="total_people" value="<%=getpeople%>" disabled="disabled"><p>
        *電話：<input type="tel" name="tel" size=14 value="<%=gettel%>" disabled="disabled"><p>
        
      </div>
      <br><input type="submit" value="修改資料">
      <input type="button" id="btn" name="back" value="回首頁" onclick="javascript:location.href='reservation.jsp'">
      
           
    </form>

</body>
</html>

