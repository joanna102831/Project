

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.Connect;


@WebServlet("/RestRanking")
public class RestRanking_Servlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		Connect con=new Connect();
		ResultSet rs = null;
		
		String id;
		String rank = "1";
		String line = "";
		String restname = "";
		String name="";
		int inrank;
		
		
		try {
		//restname="原燒";
		restname=(String) session.getAttribute("restname");
		session.setAttribute("restname", restname);
		
		String sql="select u.name,b.restname,b.id,count(*) amount from booking b,user u where b.ID=u.ID group by restname,id having restname='"+restname+"' order by amount desc";
		
		rs=con.connect("rest").executeQuery(sql);
		
			while(rs.next()){
				
				id=rs.getString("id");
				name=rs.getString("name");
				line=line+"<tr><td>第"+rank+"名</td><td>";
				line=line+"<a href=restdetal?id="+id+">";
				line=line+id+"</a></td><td>";
				line=line+name+"</td></tr>";
				
				
				inrank = Integer.valueOf(rank);
				inrank++;
				rank = String.valueOf(inrank);
			}
			
			session.setAttribute("line", line);
			session.setAttribute("restname", restname);
			response.sendRedirect("restranking.jsp");
			
		} catch (SQLException e) {
			out.print("失敗");
		}
		
		
		con.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
