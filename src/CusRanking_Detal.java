

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.Connect;


@WebServlet("/cusdetal")
public class CusRanking_Detal extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		//連線
		Connect con=new Connect();
		ResultSet rs;
		
		//=====================================================
		
		try {
		
		String userid=(String)session.getAttribute("ID");
		session.setAttribute("ID",userid);
		
		
		String str=request.getParameter("name");

	
		String sql="select * from booking where restname='"+str+"'and ID='"+userid+"'";
		String line="";
		out.print("<table border='5' width='650'><tr>");
			rs=con.connect("rest").executeQuery(sql);
			while(rs.next()) {

				line=line+"<tr><td>";
				line=line+rs.getString("NO")+"</td><td>";
				line=line+rs.getString("ID")+"</td><td>";
				line=line+rs.getString("name")+"</td><td>";
				line=line+rs.getString("restname")+"</td><td>";
				line=line+rs.getString("tel")+"</td><td>";
				line=line+rs.getString("number")+"</td><td>";
				line=line+rs.getString("date")+"</td><td>";
				line=line+rs.getString("time")+"</td></tr>";
				
				
				
			}
			//out.print(line);
			session.setAttribute("line", line);
			response.sendRedirect("cusranking_detal.jsp");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		con.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
