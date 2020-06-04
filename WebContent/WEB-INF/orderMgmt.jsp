<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id=(String)session.getAttribute("id");
session.setAttribute("id", id);

Connection con = null;
Statement stmt = null;
ResultSet rs ;

String sDriver="org.mariadb.jdbc.Driver";
String url="jdbc:mariadb://localhost/rest";

Class.forName(sDriver);
con=DriverManager.getConnection(url,"root","1234");
stmt=con.createStatement();
String str="select * from booking where id='"+id+"'";
rs=stmt.executeQuery(str);
while(rs.next()){
	session.setAttribute("id", rs.getString("ID"));
	session.setAttribute("restname", rs.getString("restname"));
	session.setAttribute("name", rs.getString("name"));
	session.setAttribute("tel", rs.getString("tel"));
	session.setAttribute("number", rs.getString("number"));
	session.setAttribute("date", rs.getString("date"));
	session.setAttribute("time", rs.getString("time"));
    }

String getid=(String)session.getAttribute("id");
String getrestname=(String)session.getAttribute("restname");
String getname=(String)session.getAttribute("name");
String gettel=(String)session.getAttribute("tel");
String getdate=(String)session.getAttribute("date");
String gettime=(String)session.getAttribute("time");
String getnumber=(String)session.getAttribute("number");
%>
<form method="post" action="http://localhost:8080/Project/doDeOrder">
<fieldset style="width:300px ; heigth:300px; position:absolute; top:15px; left:35%" >
  <legend><%=getrestname%>訂位資料</legend>
  會員帳號: <input type="text" name="id" size="15" value="<%=getid%>" disabled="disabled"><p>
   訂位人姓名: <input type="text" name="name" size="10" value="<%=getname%>"><p>
   訂位人電話: <input type="tel"  name="tel" size="20" value="<%=gettel%>"><p>
   訂位日期: <input type="date" name="date" value="<%=getdate%>"><p>
   訂位時間: <select name="time" value="<%=gettime%>"><p>
    <option name="11:00">11:00</option>
    <option name="12:00">12:00</option>
    <option name="17:00">17:00</option>
    <option name="18:00">18:00</option>
    <option name="19:00">19:00</option>
   </select>
 訂位人數: <input type="number" name="number" min="1" max="20" value="<%=getnumber%>"><p>  
   <input type="submit" value="取消訂位">
   <input type="reset" value="清除">
</fieldset>
</form>
</body>
</html>