<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>原燒</title>
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
            <h1>原燒YAKIYAN優質原味燒肉</h1>
        </div>
    </div>
    <table>
    <tr>
    <td style="width:30%;height:60% "></td>
    <td style="background-color:white"><img src="rest/rest1_home1.png" style="width:100% ;height:80%"><br>
    <p style="font:1.5em '微軟正黑體'">原燒O-NiKU (桃園台茂店)</p>
“★ 雙人厚切豚 優惠價 $1388/2人 ★ 雙人鑽切牛 優惠價 $1688/2人 ★ 雙人經典牛 優惠價 $1688/2人 （此方案為 台北林森北店/桃園統領店/板橋館前東店/宜蘭新月店/三重龍門/台中公益/桃園台茂店/嘉義耐斯店 門店限定）”<br>
    <div class="restorder" style="width:100% ;height:80% ;text-align: center"><a href="order.jsp" style="color:aliceblue;text-decoration:none " >訂位</a></div>
    </td>
    <td style="width:30%;height:60%"></td>
    </tr>
    <tr>
    <td style="width:30%;height:60% "></td>
    <td><p style="width:100% ;height:80%;font-weight: bolder; color: darkblue">餐廳資訊</p>
    
      <div style=" font-weight: bolder;color: darkgoldenrod;">地址<br></div>
      桃園市蘆竹區南崁路一段 112 號 6 樓<br><br>

      <div style=" font-weight: bolder;color: darkgoldenrod;">交通方式<br></div>
      (台北出發) 台汽客運國光號「台北-桃園機場 台北-大園 」、亞通巴士「台北-南崁」、大有巴士「台北-桃園機場」、長榮巴士「5205 台北-大園」<br>
      (桃園出發) 桃園客運「桃園-南崁-桃園機場」、「桃園-南崁-竹圍」、亞通客運「703 竹圍-南崁-中壢」</td>
    <td style="width:30%;height:60%"></td>
    </tr>
    <tr>
    <td style="width:30%;height:60% "></td>
    <td><a style="width:100% ;height:80%"></a></td>
    <td style="width:30%;height:60%"></td>
    </tr>
    </table>
<%
request.setCharacterEncoding("UTF-8");
session.setAttribute("restname","原燒");
String ID=(String)session.getAttribute("ID");
session.setAttribute("ID", ID);

%>

</body>
</html>