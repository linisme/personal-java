package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RankingJDBC {
	private Connection conn = null;
	private Statement sta =null;
	public void connectJDBC(){
		String sql = "create table if not exists ranking("
				+ "user_id  int  not null auto_increment,"
				+ "username  char(50)  not null,"
				+ "password  char(50)  not null,"
				+ "primary key (user_id))";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:"
					+ "//localhost/my?user=root&password=1235813"
					+ "&useUnicode=true&characterEncoding=UTF8&useSSL=true");
			sta = conn.createStatement();
			sta.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}					
	}

}
