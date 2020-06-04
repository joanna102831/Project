<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String line = (String) session.getAttribute("line");
	%>
	<%if(session.getAttribute("ID")==null){ %>
	<script>alert('請登入帳號密碼');window.location.href='Login_rest.html'</script>
	<%} %>
	
	<style>
	

	table{
	width:50%;	
	border-collapse:collapse;
	margin: auto;
		
	}
	h2{
	text-align:center;
	color:orange;
	padding:5px;	
	width:70%;
	margin:auto;
	margin-bottom:20px;
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
</body>
<script>
	
	function back(){
		history.back();
	}
		
</script>
<form>
	<table id="detal">
	<h2>訂位明細</h2>
		<tr>
			<th>編號</th>
			<th>帳號</th>
			<th>姓名</th>
			<th>餐廳名稱</th>
			<th>電話</th>
			<th>人數</th>
			<th>日期</th>
			<th>時間</th>
		</tr>
		<%=line%>	
	</table>
	<div style='text-align:center;'>
	<p><input type="button" value="返回" onclick="back()">
	</div>
</form>
</html>