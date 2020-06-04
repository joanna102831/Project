<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>確認資料</title>
</head>
<script>
<%
String id=(String) session.getAttribute("id");
String pw=(String) session.getAttribute("pw");
String user=(String) session.getAttribute("user");
String gender=(String) session.getAttribute("gender");
String gen;
if(gender.equals("M")){
	gen="男性";
}else{gen="女性";}
String birth=(String) session.getAttribute("birth");
String email=(String) session.getAttribute("email");
String tel=(String) session.getAttribute("tel");
%>
function back(){
	history.back();
}
function add(){
	<%
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("user", user);
	session.setAttribute("gen", gen);
	session.setAttribute("email", email);
	session.setAttribute("birth", birth);
	session.setAttribute("tel", tel);
	%>	
	document.userform.submit();
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


<body>
<h2>基本資料</h2>
<form name="userform" method="post" action="doadd">
      <div>
        <p>
        <label style='color:blue'>請再次確認資料</label><p>
        *帳號：<%=id%><p>
        *密碼：<%=pw%><p>
        *姓名：<%=user%><p> 
        *性別：<%=gen%><p>
        *生日：<%=birth%><p>
        *電話：<%=tel%><p>
        *電子信箱：<%=email%><p>
      </div>
      <br><input type="button" value="加入會員" onclick="add()">
      <input type="button" name="reset" value="修改資料" onclick="back()">     
    </form>

</body>
</html>