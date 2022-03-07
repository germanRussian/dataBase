package dao;
/**
 * 
 * 데이터베이스 연동 시험 - 이종혁
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import domain.NoticeVO;

public class NoticeDAO {

	public void create(NoticeVO vo) {

		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String passward = "smart";

		StringBuffer sql = new StringBuffer();
		sql.append("\n INSERT INTO notice ");
		sql.append("\n (no, title, content, inputDate) ");
		sql.append("\n VALUES(?, ?, ?, ?) ");

		Connection conn = null;
		PreparedStatement stmt = null;

		int idx = 1;

		try {
			// 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB연결
			conn = DriverManager.getConnection(url, user, passward);

			// sql 실행문
			stmt = conn.prepareStatement(sql.toString());

			// 값 생성
			stmt.setInt(idx++, vo.getNo());
			stmt.setString(idx++, vo.getTitle());
			stmt.setString(idx++, vo.getContent());
			stmt.setDate(idx++, vo.getInputDate());

			//
			int res = stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public List<NoticeVO> read() {

		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String passward = "smart";

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM notice ");

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		
		
		List<NoticeVO> list = new ArrayList<NoticeVO>();

		
		
		
		try {

			// 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB연결
			conn = DriverManager.getConnection(url, user, passward);

			// sql 실행문
			stmt = conn.prepareStatement(sql.toString());

			rs = stmt.executeQuery();

			// 값 생성
			while (rs.next()) {
				list.add(new NoticeVO(rs.getInt("no"), rs.getString("title"), rs.getString("content"),rs.getDate("inputDate")));

			}

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		}
		return list;
	}

}
