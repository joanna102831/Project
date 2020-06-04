<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>餐廳訂位</title>
<script language="JavaScript">
function check_order(){
	
	var fm = document.orderform;
    var str = fm.name.value;
    var str1 = fm.tel.value;
    var str2 = fm.date.value;
    var str3 = fm.time.value;
    var str4 = fm.number.value;
    var Today=new Date();
	  
	  if( str=="" )
    {
      alert( "請填訂位人姓名" );
    }
	  else if( str1=="" )
    {
      alert( "請填訂位人電話" ); 
    }
	  else if( str2=="" )
    {
      alert( "請選擇訂位日期" );
    }
	  else if(str3=="請選擇時間")
    {
      alert( "請選擇時間" ); 
    }
	  else if(str4<=0)
	{
	  alert( "人數最少為1人，請重新輸入" ); 
	  
	}
	  else if(str4=="")
	{
	  alert( "請選擇人數" ); 	  
	}
	  else{
		  fm.submit();
	  } 
}


</script>

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
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String restname=(String)session.getAttribute("restname");
session.setAttribute("restname",restname);
LocalDate today = LocalDate.now();
String ID=(String)session.getAttribute("ID");
%>
<%if(session.getAttribute("ID")==null){ 
%><script>alert('請登入帳號密碼');window.location.href='Login.html'</script><%} %>
<h2><%=restname %>訂位資料</h2>
<form name="orderform" method="post" action="http://localhost:8080/Project/doOrder">
<div><p>
  <label style='color:red'>*:必須輸入</label><p>
 會員帳號:<input type="text" name="id" size="20" value="<%=ID%>" disabled="disabled"><p>
   *訂位人姓名: <input type="text" name="name" size="10" ><p>
   *訂位人電話: <input type="tel"  name="tel" size="20" ><p>
   *訂位日期: <input type="date" name="date" min="<%=today.plusDays(1)%>" max="<%=today.plusDays(30) %>" ><p>
   *訂位時間: <select name="time"><p>
    <option  style="display:none" >請選擇時間</option>
    <option value="11:00">11:00</option>
    <option value="12:00">12:00</option>
    <option value="17:00">17:00</option>
    <option value="18:00">18:00</option>
    <option value="19:00">19:00</option>
   </select><p>
 *訂位人數: <input type="number" name="number" min="1" max="20" ><p>  
   <input type="button" value="訂位" onclick="check_order()">
   <input type="button" id="btn" name="back" value="回首頁" onclick="javascript:location.href='onepage.jsp'" >
</div>
</form>


</body>
</html>