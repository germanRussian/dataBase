package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.MemberVO;

public class MemberDAO {
	

	/**
	 * 트랜잭션 처리
	 * 
	 * @param mvo
	 */
	
	private String url = "jdbc:mysql://localhost:3306/kbLab?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
	private String user = "root";
	private String passward = "smart";
	
	String sql = " INSERT INTO kbLab.member (id, pw,uname, regdate) VALUES ( ?, ?, ?, now()) ";
			String sql1 =" INSERT INTO kbLab.login (id, pw) VALUES ( ?, ?) ";
	Connection conn = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	
	
	
	
	public void create(MemberVO mvo) {
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//디비연결
			conn = DriverManager.getConnection(url, user, passward);
		
			//sql실행1
			conn.setAutoCommit(false);
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, mvo.getId());
			stmt.setString(2, mvo.getPw());
			stmt.setString(3, mvo.getUname());
			
			stmt.executeLargeUpdate();//맴버가입
			
			//sql실행2
			stmt1 = conn.prepareStatement(sql1.toString());
			stmt1.setString(1, mvo.getId());
			stmt1.setString(2, mvo.getPw());
			
			stmt1.executeLargeUpdate();//로그인 등록
			
			conn.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();//에러가 나면 다시 돌어가라
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				//닫기
				
				if (stmt1 != null)		stmt1.close();
				if (stmt != null)		stmt.close();
				if (conn != null)		conn.close();
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
		
		
	}

}
