

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderControl
 */
@WebServlet("/OrderControl")
public class OrderControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbCon = null;
	    Statement stmt = null;
	    ResultSet rs=null;
	    ResultSet rs1=null;
	    
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/rest";
	    HttpSession session=request.getSession();
	    

	    String ID=(String)session.getAttribute("ID");
	    String NO=(String)request.getParameter("NO");
	    
	    String no;
	    String id;
	    String date = null;
	    Date a;
	    String oldnumber;
	    LocalDate today=LocalDate.now();
	    String today2=String.valueOf(today);
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    
	   
//	    String a2=request.getParameter("tel");
//	    String a3=request.getParameter("birthday");
//	    String a4=request.getParameter("email");
	        
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
	    	String str ="select NO ,ID, date from booking";
	    	
	    	String str1="select number from booking where NO='"+NO+"'";
	    	
	    	rs=stmt.executeQuery(str);
	    	rs1=stmt.executeQuery(str1);
	    	while(rs1.next()) {
	    		oldnumber=rs1.getString("number");
	    		session.setAttribute("oldnumber", oldnumber);
	    	}
	    	
	    	
			boolean check=true;
			
			while(rs.next())
			{
				id=rs.getString("ID");
				no=rs.getString("NO");
				date=rs.getString("date");
				a=sdf.parse(date);
				Date b=sdf.parse(today2);
				
				if(id.equals(ID)&&no.equals(NO)&& a.after(b)){
					check=true;
					break;
					}else{check=false;}	
				
				 
			}
			session.setAttribute("ID", ID);
			session.setAttribute("NO", NO);
			
           if(check){
			    response.sendRedirect("orderC.jsp");
			}else{//不知道有沒有其他方法 可以顯示出失敗
				response.getWriter().print("<script>alert('訂位編號輸入錯誤');window.location.href='orderControl.jsp'</script>");}

	    	
	        
	        
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
