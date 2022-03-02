package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {
	/**
	 * 
	 * DB연결
	 * 
	 * @return
	 */

	public Connection getConn() {

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

			e.printStackTrace();
		}

		return null;

	}

}
