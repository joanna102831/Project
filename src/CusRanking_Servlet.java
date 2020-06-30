
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

/**
 * Servlet implementation class CusRanking_Servlet
 */
@WebServlet("/CusRanking")
public class CusRanking_Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ResultSet rs = null;
		Connect con = new Connect();

		// 使用者輸入內容
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String ID, restname, name, line ="";
		int inrank =1;
		

		HttpSession session = request.getSession();

		
		String userid = (String) session.getAttribute("ID");

		session.setAttribute("ID", userid);
		

		try {

			String sql = "select ID,restname,count(*) amount from booking group by ID,restname having ID='" + userid
					+ "' order by amount desc";

			rs = con.connect("rest").executeQuery(sql);
			
			
			while (rs.next()) {
				name=rs.getString("restname");
				line=line+"<tr><td>第"+inrank+"名</td><td>";
				line=line+"<a href=cusdetal?name="+name+">";
				line=line+name+"</a></td></tr>";
				
				inrank++;
				if(inrank==11){
				break;
				}
				
			}
			session.setAttribute("line", line);
			response.sendRedirect("cusranking.jsp");
			

		} catch (SQLException e) {
			out.print("錯誤");
		}
		con.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
