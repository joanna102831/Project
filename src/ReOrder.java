

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


@WebServlet("/doReOrder")
public class ReOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Connection dbCon = null;
	    Statement stmt = null;
	    ResultSet rs2 = null;
	    ResultSet rs3 = null;
	    
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    
	    String sDriver = "org.mariadb.jdbc.Driver";	       
	    String user     = "root";
	    String password = "1234";
	    String url      = "jdbc:mariadb://localhost/rest";
	    HttpSession session=request.getSession();
	    
	    String id=(String)session.getAttribute("ID");
	    String NO=(String)session.getAttribute("NO");
	    String oldtel=(String)session.getAttribute("tel");
	    String olddate=(String)session.getAttribute("date");
	    String oldtime=(String)session.getAttribute("time");
	    String oldnumber=(String)session.getAttribute("number");
	    //String oldnumber =(String)session.getAttribute("oldnumber");
	    
	    String a1=request.getParameter("name");
	    String a2=request.getParameter("tel");
	    String a3=request.getParameter("date");
	    String a4=request.getParameter("time");
	    String a5=request.getParameter("number");
	    String restname=(String)session.getAttribute("restname");	      
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
	    	String str ="Update booking set tel='"+a2+"',date='"+a3+"',time='"+a4+"',number='"+a5+"',restname='"+restname+"' where NO='"+NO+"'";


	    	String str2 = "select restname,date,time,sum(number) as sumnum from booking where restname='" + restname
					+ "' and date='" + a3 + "' and time='" + a4 + "' group by restname,date,time";

		String str3 = "select total_people from restaurant where restname='"+restname+"'";
			
		String str4 = "Update booking set tel='"+oldtel+"',date='"+olddate+"',time='"+oldtime+"',number='"+oldnumber+"',restname='"+restname+"' where NO='"+NO+"'";
	    	
	    	stmt.executeUpdate(str);
	    	
	    	rs2 = stmt.executeQuery(str2);
			rs3 = stmt.executeQuery(str3);
			while (rs3.next()) {
				Integer num = Integer.valueOf(rs3.getString("total_people"));

				while (rs2.next()) {
					Integer sumnum = Integer.valueOf(rs2.getString("sumnum"));
					if (sumnum > num) {					
						stmt.executeUpdate(str4);
						response.getWriter().print("<script>alert('訂位人數已滿，若要增加人數請改選其它日期或時段，謝謝!');window.location.href='orderControl.jsp'</script>");

						break;
					}
					
				}				
			}
	    	
	        
	        response.getWriter().print("<script>alert('修改訂位完成!');window.location.href='orderControl.jsp'</script>");
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
