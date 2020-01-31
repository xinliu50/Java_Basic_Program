package practice;

import java.sql.Connection;
import java.sql.DriverManager;
public class MySQLPractice {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost3306/";
		try {
			Connection con = DriverManager.getConnection(URL,"root","abc625242321321");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connected...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
