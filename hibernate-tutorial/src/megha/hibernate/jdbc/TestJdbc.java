package megha.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String... args) {

		// driver class -- oracle.jdbc.driver.OracleDriver
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "oracle";
		String password = "password";
		try {
			System.out.println("connecting");
			
			Connection myConn=DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
