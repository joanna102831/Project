<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    
    .one{
        height: 80px;
        background: #32b3bf;
    }
    .two{
        width: 1600px;
        height: 50px;
        line-height: 60px;
        margin: 0 auto;
        color: #fff;
        text-align: right;
        border: solid 2px #fff;
        padding: 15px;
    }
    .rest{
        width:550px;
        border: solid orange 1px;
        padding: 0px;
        margin: 0px 0px 0px 0px;
    }
    h2{
        width: 550px;
        color:white;
        background-color: tomato;
        padding: 5px;
        margin: 0px;
        position: relative;
        top: 10px;
        left: 20px;
    
    }
   
       
</style>
</head>
<body class="setbody" style="background-color: palegoldenrod;">
<div class="one">
        <div class="two">
        <h3><a href="user_information.jsp" style="color:aliceblue ; text-decoration:none">會員資料管理</a> | <a href="orderControl.jsp" style="color:aliceblue ; text-decoration:none">訂位資料管理</a> | 
        <a href="CusRanking" style="color:aliceblue ; text-decoration:none">常去店家   </a> | 
        <a href="Login.html" style="color:aliceblue ; text-decoration:none" >登出</a></h3>
        </div>
</div>

<p>
<marquee direction="right" behavior="alternate" scrollamount="7" height="180" style="color:blue;font-size:xx-large ;font-weight:bold">吃飯不用等訂位網</marquee>

    

    <table>
        <tr>
            <td id="my_div">
                <img src="rest/rest1_1.png" alt="rest1_1" style="width: 600px;height:400px;">
            </td>

            <td id="my_div1">
                <img src="rest/rest2_1.jpg" alt="rest2_1" style="width: 600px;height:400px;">
            </td>

            <td id="my_div2">
                <img src="rest/rest3_1.jpg" alt="test2" style="width: 600px;height:400px;">
            </td>
        </tr>
    </table>

    <table>
    <tr>
        <td>
         <h2><a href="rest1.jsp" style="color:aliceblue; text-decoration:none">原燒YAKIYAN優質原味燒肉</a></h2>
           <pre class="rest">   
                </pre>
        </td>
        <td style="width: 35px;"></td>
        <td>
            <h2><a href="rest2.jsp" style="color:aliceblue ; text-decoration:none">HOT 7新鐵板料理</a></h2>
            <pre class="rest">  
                </pre>
        </td>
        <td style="width: 35px;"></td>
        <td>
            <h2><a href="rest3.jsp" style="color:aliceblue ; text-decoration:none">一品花雕雞</a></h2>
            <pre class="rest">  
               </pre>
        </td>
    </tr>
    </table>
    <script type="text/javascript">

        var jsImg = new Array("rest/rest1_1.png","rest/rest1_2.png","rest/rest1_3.png","rest/rest1_4.png");
        var jsImg_len = jsImg.length;  
        var a=2;                      
        setInterval("sequentialImg()",3000);
        function sequentialImg(){  
            document.getElementById("my_div").innerHTML  = "<img src='"+jsImg[a]+"' width=600 height=400>";       
                a++;
                if(a>=jsImg_len)  a=0;
        }

        var jsImg1 = new Array("rest/rest2_1.jpg","rest/rest2_2.jpg","rest/rest2_3.jpg","rest/rest2_4.jpg");
        var jsImg1_len = jsImg1.length;  
        var b=2;                      
        setInterval("sequentialImg1()",3000);
        function sequentialImg1(){  
            document.getElementById("my_div1").innerHTML  = "<img src='"+jsImg1[b]+"' width=600 height=400>";       
                b++;
                if(b>=jsImg1_len)  b=0;
        }

        var jsImg2 = new Array("rest/rest3_1.jpg","rest/rest3_2.jpg","rest/rest3_3.jpg");
        var jsImg2_len = jsImg2.length;  
        var c=2;                      
        setInterval("sequentialImg2()",3000);
        function sequentialImg2(){  
            document.getElementById("my_div2").innerHTML  = "<img src='"+jsImg2[c]+"' width=600 height=400>";       
                c++;
                if(c>=jsImg2_len)  c=0;
        }
        
        
        </script>
<%
String ID=(String)session.getAttribute("ID");
session.setAttribute("ID", ID);
%>

</body>
</html>
