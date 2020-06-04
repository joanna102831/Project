

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.Connect;


@WebServlet("/addrest")
public class Addrest_Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		Connect con=new Connect();
		Connection dbCon;
		Statement stmt;
		int data;
		
		try {
		String id=(String) session.getAttribute("id");
		String pw=(String) session.getAttribute("pw");
		String user=(String) session.getAttribute("user");
		String total=(String) session.getAttribute("total");
		String tel=(String) session.getAttribute("tel");
		
		String sql="insert into restaurant(ID,password,restname,total_people,tel) values ('"+id+"','"+pw+"','"+user+"','"+total+"','"+tel+"')";
		data=con.connect("rest").executeUpdate(sql);
		
		response.getWriter().print("<script>alert('會員加入成功');window.location.href='Login_rest.html'</script>");
		} catch (SQLException e) {
			out.print("<h1>會員加入失敗</h1>");
		}
		con.close();
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
