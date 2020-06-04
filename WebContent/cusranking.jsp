<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter,java.io.IOException,java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>常去清單</title>
</head>
<script>
<%
String  line=(String) session.getAttribute("line");

	
//傳遞id
String id=(String) session.getAttribute("ID");
session.setAttribute("ID",id);


%>
</script>
	<style>
	

	table{
	width:30%;	
	border-collapse:collapse;
	margin: auto;
		
	}
	h2{
	text-align:center;
	color:orange;
	padding:5px;	
	width:50%;
	margin:auto;
	margin-bottom:20px;
	border-bottom:double 4px orange;
	
	}
	
	td{
	border-bottom:1px solid orange;
	padding:10px;
	text-align:center;	
	color:#6E2C00  ;
	font-size:18px;
	font-weight:700;
	
	}
	th{
	padding:5px;
	font-size:20px;
	}
	
	tr:nth-child(1){
	background-color:orange;
	color:rgb(246, 246, 246);
	
	}
	tr:nth-child(even){
	background-color:#F8C471;
	}
	
	a{
	color:#7E5109 ;
	text-decoration:none;	
	}
	a:hover{
	color:#B9770E ; 
	}
	
	
	
	</style>
<body>
<%if(session.getAttribute("ID")==null){ 
%><script>alert('請登入帳號密碼');window.location.href='Login.html'</script><%} %>
	<form method="post" action="onepage.jsp">
		<h2>常去店家排行</h2>
		<table>	
		<tr><th>排名</th><th>店名</th></tr>
		<%=line%>
			
		</table>
		<div style='text-align:center;'>
		<p><input type="submit" value="離開">
		</div>
	</form>


</body>
</html>