

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Reservation")
public class Reservation_Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbCon;
		Statement stmt;
		
		
		String sDriver="org.mariadb.jdbc.Driver";
		String user="root";
		String password="1234";
		String url="jdbc.mariadb://localhost/rest";
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName(sDriver);
		} catch (ClassNotFoundException e) {
			out.print("無法連到驅動程式");
			
		}
		try {
			dbCon=DriverManager.getConnection(url,user,password);
			stmt=dbCon.createStatement();
		} catch (SQLException e) {
			out.print("");
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
