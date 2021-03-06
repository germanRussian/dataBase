package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;


/**
 * 
 * JDBC 프로그래밍 mysql DB와 연동되어 콘솔에 DB를 띄울 수 있다.
 * 
 * 이장에서는 내용을 등록해 보겠다. 
 * 
 * 한개씩 등록 가능하다.
 * 
 * 6장에서 실행을 한번하면, 5장 실행에서 추가된것을 확인할 수 있다.
 * C
 * 
 * @author smart17
 *
 */
public class Simple6JDBCDAO {

	public static void main(String[] args) {

		String paramVarchar = "varcharTest";
		String paramChar = "charTest";
		double paramInt = 222.333;
		Date paramDate = new Date(System.currentTimeMillis());
		Timestamp paramDateTime = new Timestamp(System.currentTimeMillis());
		

		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "INSERT INTO exam VALUES(?,?,?,?,?)";


		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;


		try {
			// 1. 드라이버 로드(Class.forName()) - 어떤 데이터베이스 사용할꺼냐
			Class.forName("com.mysql.cj.jdbc.Driver");

//			2. DB연결(DriverManager.getConnection())
			conn = DriverManager.getConnection(url, user, password);

//			3. SQL문작성(Statement, PrepareStatement) - sql직접 실행하거나, 값 설정하고 실행하거나 / PrepareStatement을 주로 사용, Statement는 해킹의 우려가 있다.
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, paramVarchar);
			stmt.setString(2, paramChar);
			stmt.setDouble(3, paramInt);
			stmt.setDate(4, paramDate);
			stmt.setTimestamp(5, paramDateTime);
			
			

//			4. SQL문실행(executeQuery(), executeUpdate())
			int res = stmt.executeUpdate();
			if(res>0) {
				System.out.println(res + "개의 행이 추가 되었습니다.");
			}else {
				System.out.println("등록 실패했습니다.");
			}
//			5. Select문 만 ResultSet 객체를 반환한다. 나머지는 int를 반환한다.

			

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			// 6. 닫기(close())
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
