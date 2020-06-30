

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

	    	
	    	String str="select * from booking where id='"+ID+"' and date>'"+today+"'";
	
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
	            
	    	}
	    	session.setAttribute("line", line);
	    	response.sendRedirect("order_detal.jsp");
	    	
	    	
	    
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
