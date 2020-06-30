

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Rest_information3
 */
@WebServlet("/Rest_information3")
public class Rest_information3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbCon = null;
	    Statement stmt = null;
	    
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/rest";
	    HttpSession session=request.getSession();
	    

	    String id=(String)session.getAttribute("ID");
	    
	    String a1=request.getParameter("pw");
	    String a2=request.getParameter("restname");
	    String a3=request.getParameter("tel");
	    String a4=request.getParameter("total_people");
	        
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
	    	String str ="Update restaurant set password='"+a1+"', restname='"+a2+"',tel='"+a3+"',total_people='"+a4+"' where ID='"+id+"'";

	    	stmt.executeUpdate(str);
	        
	        response.getWriter().print("<script>alert('會員資料修改完成!');window.location.href='reservation.jsp'</script>");
	        
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
		
		doGet(request, response);
	}

}
