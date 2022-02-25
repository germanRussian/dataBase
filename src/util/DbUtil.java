package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

	// DB 연결
	public Connection dbconn() {

		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String passward = "smart";
		
		Connection conn = null;
		
		
		try {
			// 드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB연결
			conn = DriverManager.getConnection(url, user, passward);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	// DB 해제[닫기]
	public static void dbClose(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
