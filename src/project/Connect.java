package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class Connect {
	private Connection dbCon;
	private Statement stmt;	
	
//	public Connect(Connection dbCon,Statement stmt) {
//		this.dbCon=dbCon;
//		this.stmt=stmt;
//	}

	public Connect() {
		// TODO Auto-generated constructor stub
	}

	public Statement connect(String database){	
		
		String sDriver="org.mariadb.jdbc.Driver";
		String user="root";
		String password="1234";
		String url="jdbc:mariadb://localhost/"+database;

		try{
			Class.forName(sDriver);
		}catch(Exception e){
			System.out.println("無法載入驅動程式");
	           
		}
		try{
			dbCon=DriverManager.getConnection(url, user, password);
			stmt=dbCon.createStatement();
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
	           
		}
		return stmt;
		
	}
	
	public void close(){
		try {
			stmt.close();
			dbCon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}


