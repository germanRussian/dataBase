package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * JDBC 프로그래밍
 * mysql DB와 연동되어 콘솔에 DB를 띄울 수 있다.
 * 
 * @author smart17
 *
 */
public class SimpleJDBCDAO {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "SELECT * FROM exam";

//		1. 드라이버 로드(Class.forName()) - 어떤 데이터베이스 사용할꺼냐
		Class.forName("com.mysql.cj.jdbc.Driver");

//		2. DB연결(DriverManager.getConnection())
		Connection conn =  DriverManager.getConnection(url, user, password);

//		3. SQL문작성(Statement, PrepareStatement) - sql직접 실행하거나, 값 설정하고 실행하거나 / PrepareStatement을 주로 사용, Statement는 해킹의 우려가 있다.
		Statement stmt = conn.createStatement();
		
		
//		4. SQL문실행(executeQuery(), executeUpdate())
		ResultSet rs =  stmt.executeQuery(sql);
		
//		5. Select문 만 ResultSet 객체를 반환한다. 나머지는 int를 반환한다.
		rs.next();//첫번째 줄의 데이터만 가져옴
		rs.next();// 두번재도 가져옴
		System.out.println(rs.getString("varcharTest"));
		System.out.println(rs.getString("intTest"));
		
		
//		6. 닫기(close())
		rs.close();
		stmt.close();
		conn.close();
		
	}

}
