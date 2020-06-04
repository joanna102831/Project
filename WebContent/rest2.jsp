<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hot 7</title>
<style>
    
    .one{
        height: 80px;
        background: #32b3bf;
    }
    .two{
        width: 1000px;
        height: 80px;
        line-height: 45px;
        margin: 0 auto;
        color: #fff;
        text-align: center;
        border: solid 2px #fff;
    }
    .restorder{
        color:white;
        background-color: tomato;
        padding: 0px;
        margin: 0px;
        position: relative;
        top: 10px;
        left: 0px;;
        font-size:xx-large
    
    }
    pre{
        padding: 0px;
        margin: 5px 0px 0px 0px;
        font-size:large
    }
    h2{
        width: 550px;
        color:white;
        background-color: tomato;
        padding: 5px;
        margin: 0px;
        position: relative;
        top: 10px;
        left: 10px;
    
    }
        
</style>
</head>
<body style="background-color:	WhiteSmoke">
<div class="one">
        <div class="two">
            <h1>HOT 7 新鉄板料理</h1>
        </div>
    </div>
    <table>
    <tr>
    <td style="width:25%;height:60% "></td>
    <td style="background-color:white"><img src="rest/rest2_home3.png" style="width:100% ;height:80%"><br>
    <p style="font:1.5em '微軟正黑體'">hot 7 新鉄板料理 - 台北長安東店</p>
“★ 預付 兩客套餐 $658/2人 ，贈送『 主廚私房招待菜乙份 』”<br>
    <div class="restorder" style="width:100% ;height:80%;text-align: center"><a href="order.jsp" style="color:aliceblue;text-decoration:none" >訂位</a></div>
    </td>
    <td style="width:25%;height:60%"></td>
    </tr>
    <tr>
    <td style="width:25%;height:60% "></td>
    <td><p style="width:100% ;height:80%;font-weight: bolder; color: darkblue">餐廳資訊</p>
    
     <div style=" font-weight: bolder;color: darkgoldenrod;"> 地址<br></div>
      台北市中山區長安東路二段78-2號<br><br>

     <div style=" font-weight: bolder;color: darkgoldenrod;"> 交通方式<br></div>
     台北捷運:松江南京站、忠孝新生站<br>
     </td>
    <td style="width:25%;height:60%"></td>
    </tr>
    <tr>
    <td style="width:25%;height:60% "></td>
    <td><a style="width:100% ;height:80%"></a></td>
    <td style="width:25%;height:60%"></td>
    </tr>
    </table>


<%
request.setCharacterEncoding("UTF-8");
session.setAttribute("restname","Hot7");
String ID=(String)session.getAttribute("ID");
session.setAttribute("ID", ID);

%>

</body>
</html>