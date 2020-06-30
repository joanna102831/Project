

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


@WebServlet("/restdetal")
public class RestRanking_Detal extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		//連線
		Connect con=new Connect();
		ResultSet rs;
		
		//=====================================================
		
		try {
		
		String restname=(String)session.getAttribute("restname");
		
		
		String id=request.getParameter("id");

	
		String sql="select * from booking where restname='"+restname+"'and ID='"+id+"'order by date";
		String line="";
		
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
			response.sendRedirect("restranking_detal.jsp");
		
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		con.close();
		
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
