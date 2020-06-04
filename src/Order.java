
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Order
 */
@WebServlet("/doOrder")
public class Order extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection dbCon = null;
		Statement stmt = null;
		HttpSession session = request.getSession();

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		String sDriver = "org.mariadb.jdbc.Driver";
		String user = "root";
		String password = "1234";
		String url = "jdbc:mariadb://localhost/rest";

		String a1 = request.getParameter("name");
		String a2 = request.getParameter("tel");
		String a3 = request.getParameter("date");
		String a4 = request.getParameter("time");
		String a5 = request.getParameter("number");
		String restname = (String) session.getAttribute("restname");
		String id = (String) session.getAttribute("ID");
		session.setAttribute("ID", id);

		try {
			Class.forName(sDriver);
		} catch (Exception e) {
			out.print("<h1>無法載入驅動程式</h1>");
			return;
		}

		try {
			dbCon = DriverManager.getConnection(url, user, password);
			stmt = dbCon.createStatement();
		} catch (SQLException e) {
			out.println("與資料來源連結錯誤");
			return;
		}

		try {
			String str = "INSERT INTO booking(name,tel,date,time,number,restname,ID) VALUES ('" + a1 + "','" + a2
					+ "','" + a3 + "','" + a4 + "','" + a5 + "','" + restname + "','" + id + "')";

			String str1 = "select NO from booking where id='" + id + "' and restname='" + restname + "' and date='" + a3
					+ "' and name='"+a1+"' and tel='"+a2+"' and time='"+a4+"' and number='"+a5+"' order by NO desc";

			String str2 = "select restname,date,time,sum(number) as sumnum from booking where restname='" + restname
					+ "' and date='" + a3 + "' and time='" + a4 + "' group by restname,date,time";

			String str3 = "select total_people from restaurant where restname='"+restname+"'";
			
			String str4 = "Delete from booking where name='" + a1 + "'and tel='" + a2+ "' and date='" + a3 + "' and time='" + a4 + "' and "
					+ "number='" + a5 + "' and restname='" + restname + "' and ID='" + id + "'";

			stmt.executeUpdate(str);

			rs = stmt.executeQuery(str1);
			rs2 = stmt.executeQuery(str2);
			rs3 = stmt.executeQuery(str3);
			
			outer:
			while (rs3.next()) {
				Integer num = Integer.valueOf(rs3.getString("total_people"));

				while (rs2.next()) {
					Integer sumnum = Integer.valueOf(rs2.getString("sumnum"));
					if (sumnum > num) {					
						stmt.executeUpdate(str4);

						out.println("<h1>訂位人數已滿，請選別的日期預訂</h1>");
						break;
					}

					while (rs.next()) {
						out.println("<center><h2>訂位完成!</h2></center>");
						out.println("\n");
						out.println(
								"<center><h1>訂位編號為：</h1>" + "<h1>" + rs.getString("NO") + "</h1>" + "<h2>修改訂位須以訂位編號來查詢修改</h2></center>");
						break outer;
					}
				}
				
				response.getWriter().print("<script>alert('訂位人數已滿，請選別的日期或時間預訂');window.location.href='order.jsp'</script>");
			}
			
			response.setHeader("refresh", "5;url=http://localhost:8080/Project/onepage.jsp");
		} catch (Exception e) {
			out.println("資料無法輸入");
		}

		try {
			stmt.close();
			dbCon.close();
		} catch (SQLException e) {
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
