

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.Connect;


@WebServlet("/LoginRest")
public class Login_Rest extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			ResultSet rs=null;
			HttpSession session=request.getSession();
			
			Connect con=new Connect();
		
			request.setCharacterEncoding("utf-8");
			String id=request.getParameter("id");
			String passwd=request.getParameter("passwd");
			session.setAttribute("ID", id);
			
			response.setContentType("text/html;charset=utf-8");
		    PrintWriter out=response.getWriter();
		    
		    String ID,Password,name = null;
			
			
		    try {
				String sql="select ID,Password,restname from restaurant";
				rs=con.connect("rest").executeQuery(sql);
				boolean check=true;
				
				

				while(rs.next())
				{
					ID=rs.getString("ID");
					Password=rs.getString("Password");
					name=rs.getString("restname");
					session.setAttribute("restname", name);
					
					if(ID.equals(id)&&Password.equals(passwd)){
						check=true;
						break;
						}else{check=false;}				
				}
				
			
				if(check){
					
					response.getWriter().print("<script>alert('歡迎使用');window.location.href='reservation'</script>");

				}else{
					response.getWriter().print("<script>alert('帳號或密碼錯誤');window.location.href='Login_rest.html'</script>");}
				
				
			} catch (SQLException e) {
				out.print("錯誤"+e);
			}
			
			con.close();
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
