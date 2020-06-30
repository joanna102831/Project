

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.Connect;


@WebServlet("/Login")
public class Login_Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet rs=null;
		HttpSession session=request.getSession();
		
		Connect con=new Connect();
	
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	    
	    String ID,Password;
		
		
	    try {
			String sql="select ID,Password from user";
			rs=con.connect("rest").executeQuery(sql);
			boolean check=true;
			
			

			while(rs.next())
			{
				ID=rs.getString("ID");
				Password=rs.getString("Password");
				session.setAttribute("ID", ID);
				
				if(ID.equals(id)&&Password.equals(passwd)){
					check=true;
					break;
					}else{check=false;}				
			}
			
		
			if(check){
				
				response.getWriter().print("<script>alert('歡迎使用');window.location.href='onepage.jsp'</script>");

			}else{
				response.getWriter().print("<script>alert('帳號或密碼錯誤');window.location.href='Login.html'</script>");}
			
			
			
			
		} catch (SQLException e) {
			out.print("錯誤");
		}
		
		con.close();
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
