

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/doDeOrder")
public class DeOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		Connection dbCon=null;
		Statement stmt=null;
		
		String sDriver = "org.mariadb.jdbc.Driver";
		String user ="root";
		String password ="1234";
		String url ="jdbc:mariadb://localhost/rest";
		HttpSession session=request.getSession();
		
		String NO=(String)session.getAttribute("NO");

		
		try {
			Class.forName(sDriver);
		} catch (ClassNotFoundException e) {
			out.print("無法載入驅動程式");
		}
		try {
			dbCon=DriverManager.getConnection(url,user,password);
			stmt=dbCon.createStatement();
		} catch(Exception e) {
			out.print("與資料來源連結錯誤");
		}
		try {
			String str="Delete from booking where NO='"+NO+"'";
			stmt.executeUpdate(str);
			response.getWriter().print("<script>alert('訂位編號"+NO+"取消訂位完成!');window.location.href='orderControl.jsp'</script>");

		} catch (Exception e) {
			out.print("取消訂位失敗");
		}
		
		try {
			stmt.close();
			dbCon.close();
		} catch(Exception e) {
			
		}
			
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
