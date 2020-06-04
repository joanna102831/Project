

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CallOrder")
public class CallOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		Connection dbCon = null;
	    Statement stmt = null;
	    HttpSession session=request.getSession();
	    
//	    request.setCharacterEncoding("utf-8");
//	    response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset='UTF-8'");
	    
	    
	   
	    ResultSet rs=null;
	    
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/rest";
	    
	    String ID=(String)session.getAttribute("ID");
	    String line="";
	    
	    
	    
	    try{     
	    	Class.forName(sDriver);
	    }
	    catch(Exception e){
	    	out.print("<h1>無法載入驅動程式</h1>");
	        return;
	    }
	       
	    try   
	    {
	        dbCon = DriverManager.getConnection(url,user,password);
	        stmt = dbCon.createStatement();
	        
	    }
	    catch(SQLException e)
	    {
	        out.println("與資料來源連結錯誤");
	        return;
	    }

	    try{ 
	    	out.print("<!DOCTYPE HTML>");
	    	out.print("<html lang='zh-TW'>");
	    	out.print("<head><meta charset='utf-8'></head>");
	    	out.print("<body>");
	    	out.print("測試");
	    	String str="select * from bookingg where id='"+ID+"'";
	    	out.print("<table border='5' width='500'><tr>");
	    	out.print("<h1>測試</h1>");
	    	out.print("<th><h1>帳號</h1></th><th>訂位編號  </th><th>餐廳名稱   </th><th>訂位人   </th><th>聯絡電話   </th><th>訂位日期   </th><th>訂位時間</th><th>訂位人數</th></tr>");
	    	
	    	rs=stmt.executeQuery(str);
	    	while(rs.next()){
	    		line="<tr><td>";
	        	line=line+rs.getString("ID")+"</td><td>";
	        	line=line+rs.getString("NO")+"</td><td>";
	        	line=line+rs.getString("restname")+"</td><td>";
	        	line=line+rs.getString("name")+"</td><td>";
	        	line=line+rs.getString("tel")+"</td><td>";
	        	line=line+rs.getString("date")+"</td><td>";
	        	line=line+rs.getString("time")+"</td><td>";
	        	line=line+rs.getString("number")+"</td></tr>";
	            out.print(line);
	        	
	        	
	    		
	    	}
	    	out.print("</body>");
	    	out.print("</html>");
	    	session.setAttribute("line",line);
	    	out.print("測試");
	    	response.setHeader("refresh", "3;url=http://localhost:8080/Project/test.jsp");
	    	
	    	
//	    	response.getWriter().print("<script>alert('訂位成功');window.location.href='onepage.jsp'</script>");
	        
	        //response.setHeader("refresh", "10;url=http://localhost:8080/Project/onepage.jsp");
	    }
	    catch(Exception e){
	    	out.println("資料無法輸入");
	    }
	    	    
	    try{	        
	    	stmt.close(); 
	        dbCon.close(); 
	    }
	    catch( SQLException e ){}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
