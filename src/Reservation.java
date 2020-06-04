

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.Connect;


@WebServlet("/reservation")
public class Reservation extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		Connect con=new Connect();
		ResultSet rs;
		
		String restname=(String) session.getAttribute("restname");
		String line="";
		

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(new Date());
		
		
		
		
		try {
			String sql="select * from booking where restname='"+restname+"' and date>='"+today+"'order by date,time";
			rs=con.connect("rest").executeQuery(sql);
			
			while(rs.next()){
				
				
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
			
			session.setAttribute("line", line);
			session.getAttribute("ID");
			response.sendRedirect("reservation.jsp");
			
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
