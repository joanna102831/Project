<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.io.*,javax.servlet.http.HttpServletResponse,javax.servlet.RequestDispatcher"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改訂位</title>

</head>
<style type="text/css">
		#frist1{
			width:30%;
			margin: auto;
		}

    	div {		
		border-style:double hidden;
		border-width: 3px;
		border-color: orange;
		
    	}
			
    </style>
<body id="frist1">
<%
String ID =(String)session.getAttribute("ID");
session.setAttribute("ID",ID);


%>
<%if(session.getAttribute("ID")==null){ 
%><script>alert('請登入帳號密碼');window.location.href='Login.html'</script><%} %>
<h2>訂位資料管理</h2>
  <form name="cform"method="post" action="http://localhost:8080/Project/OrderControl">  
    <div>
     <p><ul>
        <li>會員帳號:<input type="text" id="id" size="20" value="<%=ID %>" disabled="disabled"><p>
        <li>請輸入訂位編號(三位數):<input type="text" name="NO" size="20" required><p>
        </ul>
        <input type="hidden" type="text" name="var" id="test">
        <input type="submit" value="修改訂位資料">
        <input type="button" onclick="getDate();" value="訂位編號查詢">
        <input type="button" id="btn" name="back" value="回首頁" onclick="javascript:location.href='onepage.jsp'" >
       
    </div>
  </form>
  <div id="content"></div>
  
  <script>
  function getDate(){
	  var req=new XMLHttpRequest();
	  req.open("get","http://localhost:8080/Project/CallOrder2");
	  req.onload=function(){
		  var content=document.getElementById("content");
		  content.innerHTML=this.responseText;
	  };
	  req.send();
  }
  </script>
  
  
</body>
</html>
