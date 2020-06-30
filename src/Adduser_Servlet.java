

import java.io.IOException;
import project.Connect;

import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/doadd")
public class Adduser_Servlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		
		int rs;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//連線
		Connection dbCon;
		Statement stmt;
		Connect con=new Connect();
		
		
	
		try{
			String id=(String) session.getAttribute("id");
			String pw=(String) session.getAttribute("pw");
			String user=(String) session.getAttribute("user");
			String gender=(String) session.getAttribute("gender");
			String birth=(String) session.getAttribute("birth");
			String email=(String) session.getAttribute("email");
			String tel=(String) session.getAttribute("tel");
			
			
			
			String sql="insert into user (ID,Password,Name,Gender,Birthday,tel,Email) values ('"+id+"','"+pw+"','"+user+"','"+gender+"','"+birth+"','"+tel+"','"+email+"')";
			rs=con.connect("rest").executeUpdate(sql);
			
			response.getWriter().print("<script>alert('會員加入成功');window.location.href='Login.html'</script>");
			
			
		}catch(Exception e){
			out.print("<h1>會員加入失敗</h1>");
		}
		
		con.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
