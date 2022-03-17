package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import domain.BoardDTO;
import domain.BoardVO;

public class BoardDAO {

	private String url = "jdbc:mysql://localhost:3306/kbLab?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
	private String user = "root";
	private String passward = "smart";

	
	
	//1. 입력
	public void create(BoardVO vo) {

		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO kbLab.board (board_id, writer, title, content, regdate, hit) ");
		sql.append(" VALUES ( 0, ?, ?, ?, now(), 0) ");

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// 드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB연동
			conn = DriverManager.getConnection(url, user, passward);

			// PrepareStatament(SQL작성 및 실행)
			stmt = conn.prepareStatement(sql.toString());

			// 값 설정(쿼리 문 '?'에 들어 갈 값)
			stmt.setString(1, vo.getWriter());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getContent());

			// 출력
			stmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	
	//2. 전체 출력 - 여러개 가져오기
	public List<BoardVO> read() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<BoardVO> list = new ArrayList<BoardVO>();
		

		StringBuffer sql = new StringBuffer();
		sql.append(" select b.board_id,  m.uname as writer, b.content, b.title, b.regdate, b.hit ");
		sql.append(" from board as b ");
		sql.append(" join member as m ");
		sql.append(" on b.writer = m.id ");
		sql.append(" order by b.board_id desc ");

		try {

			// 드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 디비연결
			conn = DriverManager.getConnection(url, user, passward);

			// sql작성문
			stmt = conn.prepareStatement(sql.toString());

			// sql실행문
			rs = stmt.executeQuery();

			// 결과처리
			while (rs.next()) {


				list.add(new BoardVO(rs.getInt("board_id"), 
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"), 
						rs.getTimestamp("regdate"), 
						rs.getInt("hit")));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list;

	}

	
	//3. 검색 출력 - 여러거 가져오기
	public List<BoardVO> read(BoardDTO dto) {

		StringBuffer sql = new StringBuffer();
		sql.append(" select b.board_id, m.uname as writer, b.title, b.content,  b.regdate, b.hit ");
		sql.append(" from board as b ");
		sql.append(" join member as m ");
		sql.append(" on b.writer = m.id ");
		
		if("title".equals(dto.getSfl())) {
			sql.append(" where b.title like ? ");
		}
		if("content".equals(dto.getSfl())) {
			sql.append(" where b.content like ? ");
		}
		if("title|content".equals(dto.getSfl())) {
			sql.append(" where b.title like ? or b.content like ? ");
		}
		
		sql.append(" order by b.board_id desc ");

	
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, passward);
			
			stmt = conn.prepareStatement(sql.toString());
			
			
			if("title".equals(dto.getSfl())) {
				stmt.setString(1, "%" + dto.getKeword() + "%");
			}
			
			if("content".equals(dto.getSfl())) {
				stmt.setString(1, "%" + dto.getKeword() + "%");
			}
			if("title|content".equals(dto.getSfl())) {
				stmt.setString(1, "%" + dto.getKeword() + "%");
				stmt.setString(2, "%" + dto.getKeword() + "%");
			}
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {

				list.add(new BoardVO(
						rs.getInt("board_id"), 
						rs.getString("writer"), 
						rs.getString("title"),
						rs.getString("content"), 
						rs.getTimestamp("regdate"), 
						rs.getInt("hit")));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if (rs != null)
					rs.close();
				
				if (conn != null)
					conn.close();
				
				if (stmt != null)
					
					stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}
	
	//4. 한개의 게시글 보기
	public BoardVO read(BoardVO bvo){
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select b.board_id, m.uname as writer, b.title, b.content,  b.regdate, b.hit ");
		sql.append(" from board as b ");
		sql.append(" join member as m ");
		sql.append(" on b.writer = m.id ");
		sql.append(" where b.board_id = ? ");
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		BoardVO vo = null;
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, passward);
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, bvo.getBoard_id());//pk를 가진 id만 가져와도 된다.
		
			rs = stmt.executeQuery();
			
			
			//반복을 할 필요 없기에 while문을 쓰지 않는다. if문으로 충분하다.
			if (rs.next()) {

				vo = new BoardVO(
						rs.getInt("board_id"), 
						rs.getString("writer"), 
						rs.getString("title"),
						rs.getString("content"), 
						rs.getTimestamp("regdate"), 
						rs.getInt("hit"));
			}

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			try {
				if (rs != null)	rs.close();				
				if (conn != null) conn.close();
				if (stmt != null) stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
		return vo;
	}
}

