

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

/**
 * Servlet implementation class A1
 */
@WebServlet("/OrderOut")
public class OrderOut extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbCon = null;
	    Statement stmt = null;
	    ResultSet rs;
	    String name;
	    
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/rest";
	    HttpSession session=request.getSession();
	    String id=(String)session.getAttribute("ID");
	    	      
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
	    	String str ="SELECT * FROM BOOKING where id='"+id+"'";

	    	rs=stmt.executeQuery(str);
	    	
	    	
	    while(rs.next()){
	    	session.setAttribute("id", rs.getString("ID"));
	    	session.setAttribute("restname", rs.getString("restname"));
	    	session.setAttribute("name", rs.getString("name"));
	    	session.setAttribute("tel", rs.getString("tel"));
	    	session.setAttribute("number", rs.getString("number"));
	    	session.setAttribute("date", rs.getString("date"));
	    	session.setAttribute("time", rs.getString("time"));
	    	response.sendRedirect("orderC.jsp");
	    }
	    	
	        out.println();
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
