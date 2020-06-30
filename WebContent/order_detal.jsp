<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢訂位編號</title>
<style>
	
	table{
	width:800px;	
	border-collapse:collapse;
		
	}
	.seth2{
	
	color:orange;
	padding:5px;	
	width:750px;
	border-bottom:double 4px orange;
	
	}
	
	td{
	border-bottom:1px solid orange;
	padding:10px;
	text-align:center;	
	color:#7E5109;
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
	
	</style>
</head>
<body>

	<%
		String line = (String) session.getAttribute("line");
	%>
	
	<form>
	<table>
	<h2 class="seth2">訂位明細</h2>
		<tr>
			<th>帳號</th>
			<th>訂位編號</th>
			<th>餐廳名稱</th>
			<th>訂位人</th>
			<th>聯絡電話</th>
			<th>訂位日期</th>
			<th>訂位時間</th>
			<th>訂位人數</th>
		</tr>
		<%=line%>	
	</table>
	
</form>
	
</body>

</html>
