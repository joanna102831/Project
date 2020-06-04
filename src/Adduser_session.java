

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/dosession")
public class Adduser_session extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String use=request.getParameter("user");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String birth=request.getParameter("birthday");
		String tel=request.getParameter("tel");
		
		
		PrintWriter out=response.getWriter();
		
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setAttribute("user", use);
		session.setAttribute("gender", gender);
		session.setAttribute("email", email);
		session.setAttribute("birth", birth);
		session.setAttribute("tel", tel);

	        
		
		response.sendRedirect("showdata.jsp");
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
