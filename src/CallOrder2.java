

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CallOrder2
 */
@WebServlet("/CallOrder2")
public class CallOrder2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbCon = null;
	    Statement stmt = null;
	    HttpSession session=request.getSession();
	    LocalDate today =LocalDate.now();
	    
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    ResultSet rs=null;
	    String line="";
	    String ID=(String)session.getAttribute("ID");
	    
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/rest";
	    
	    
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
//	    	out.print("<!DOCTYPE HTML>");
//	    	out.print("<html lang='zh-TW'>");
//	    	out.print("<head><meta charset='utf-8'></head>");
//	    	out.print("<body>");
	    	
	    	String str="select * from booking where id='"+ID+"' and date>'"+today+"'";
//	    	out.print("<table border='5' width='650'><tr>");
//	    	
//	    	out.print("<th>帳號</th><th>訂位編號</th><th>餐廳名稱</th><th>訂位人</th><th>聯絡電話</th><th>訂位日期</th><th>訂位時間</th><th>訂位人數</th></tr>");
	    	
	    	rs=stmt.executeQuery(str);
	    	while(rs.next()){
	    		line=line+"<tr><td>";
	        	line=line+rs.getString("ID")+"</td><td>";
	        	line=line+rs.getString("NO")+"</td><td>";
	        	line=line+rs.getString("restname")+"</td><td>";
	        	line=line+rs.getString("name")+"</td><td>";
	        	line=line+rs.getString("tel")+"</td><td>";
	        	line=line+rs.getString("date")+"</td><td>";
	        	line=line+rs.getString("time")+"</td><td>";
	        	line=line+rs.getString("number")+"</td></tr>";
	            //out.print(line);
	        	
	    	}
	    	session.setAttribute("line", line);
	    	response.sendRedirect("order_detal.jsp");
//	    	out.print("</body>");
//	    	out.print("</html>");
	    	
	    	
	    	//response.setHeader("refresh", "3;url=http://localhost:8080/Project/test.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
