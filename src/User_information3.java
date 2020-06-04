

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

@WebServlet("/User_information3")
public class User_information3 extends HttpServlet {
	
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
	    String a2=request.getParameter("tel");
	    String a3=request.getParameter("birthday");
	    String a4=request.getParameter("email");
	        
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
	    	String str ="Update user set password='"+a1+"', tel='"+a2+"',birthday='"+a3+"',email='"+a4+"' where ID='"+id+"'";

	    	stmt.executeUpdate(str);
	        
	        //out.println("修改完成!");
	        response.getWriter().print("<script>alert('會員資料修改完成!');window.location.href='onepage.jsp'</script>");
	        //response.setHeader("refresh", "3;url=http://localhost:8080/Project/onepage.jsp");
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
