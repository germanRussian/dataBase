package dao;

import java.sql.*;
import java.util.ArrayList;

/**
 * 데이터 관리
 * CRUD는 한 개의 메인에 들어가야한다.
 * 
 * 아래의 코드는 그것을 작업해 보도록 하겠다.
 */

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import domain.ExamVO;
import util.Dbutil;

public class ExamDAO extends Dbutil {

	/**
	 * 
	 * 데이터 베이스 쿼리 CRUD의 묶음
	 * C:creat() - 등록하는 메소드 접근지정자 : publics param : 등록될 값 return :없음
	 * 
	 * @author smart17
	 *
	 */
	public void create(ExamVO vo) {
		// 코드 작성

		StringBuffer sql = new StringBuffer();
		sql.append("\n INSERT INTO exam");
		sql.append("\n (varcharTest, charTest, doubleTest, dateTest, dateTimeTest)");
		sql.append("\n VALUES(?, ?, ?, ?, ?)");

		Connection conn = null;
		PreparedStatement stmt = null;
		int idx = 1; // 0으로 시작할때는 ++inx 사용

		try {

			// conn = new Dbutil.getConn(); - has a 방식
			conn = getConn();// is a 방식

			// PrepareStatament(SQL작성 및 실행)
			stmt = conn.prepareStatement(sql.toString());

			// ?값 설정
			stmt.setString(idx++, vo.getVarcharTest());
			stmt.setString(idx++, vo.getCharTest());
			stmt.setDouble(idx++, vo.getDoubleTest());
			stmt.setDate(idx++, new Date(vo.getDateTest().getTime()));
			stmt.setTimestamp(idx++, vo.getDateTimeTest());

			int res = stmt.executeUpdate();// 데이터 삽입

		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
			dbClose(conn, stmt, null);

		}

	}

	/**
	 * R:read() - 등록하는 메소드 접근지정자 : publics param : 조회할 값 return :List
	 * 
	 * @author smart17
	 *
	 */

	// 전체 내용 보여주기
	public List read() {
		// 코드 작성

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM exam ");

		Connection conn = null;
		PreparedStatement stmt = null;

		ResultSet rs = null;

		List<ExamVO> list = new ArrayList<ExamVO>();

		try {
			
			// DB연결
			conn = getConn();

			// PreparStatament(SQL작성 및 실행)
			stmt = conn.prepareStatement(sql.toString());

			rs = stmt.executeQuery(); // 실행

			// 결과처리(Select문만 ResultSet 객체 리턴)
			while (rs.next()) {
				list.add(new ExamVO(rs.getInt("num"), rs.getString("varcharTest"), rs.getString("charTest"),
						rs.getDouble("doubleTest"), rs.getDate("dateTest"), rs.getTimestamp("dateTimeTest")));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			dbClose(conn, stmt, rs);
		}
		return list;
	}

	// 일부 내용 가져오기 - 해당되는 게시물을 보기 위한 작업
	public ExamVO read(ExamVO vo) {
		// 코드 작성

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM exam WHERE num = ? ");

		ExamVO examVo = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ExamVO examvo = null;
		ResultSet rs = null;

		try {
			

			// 연결
			conn = getConn();
			// PreparedStatment(SQL문 + 실행)
			stmt = conn.prepareStatement(sql.toString());

			stmt.setInt(1, vo.getNum());

			rs = stmt.executeQuery();

			if (rs.next()) {
				examVo = new ExamVO(rs.getInt("num"), rs.getString("varcharTest"), rs.getString("charTest"),
						rs.getDouble("doubleTest"), rs.getDate("dateTest"), rs.getTimestamp("dateTimeTest"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			dbClose(conn, stmt, rs);
		}

		// 코드작성 끝
		return examVo;

	}

	/**
	 * U:Update() - 수정하는 메소드 접근지정자 : publics param : 수정될 값 return :없음
	 * 
	 * @author smart17
	 * @return
	 *
	 */
	public void update(ExamVO vo) {

		StringBuffer sql = new StringBuffer();
		// sql.append(" UPDATE exam SET varcharTest = ? WHERE 1 ");
		sql.append(" UPDATE exam ");
		sql.append(" SET varchartest = ?, doubleTest = ? ");
		sql.append(" WHERE num = ? ");

		Connection conn = null;
		PreparedStatement stmt = null;

		int idx = 1;

		try {
			
			// DB연결
			conn = getConn();

			// PrepareStatament(SQL작성 및 실행)
			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(idx++, vo.getVarcharTest());
			stmt.setDouble(idx++, vo.getDoubleTest());
			stmt.setInt(idx++, vo.getNum());

			int res = stmt.executeUpdate();
			if (res > 0) {
				System.out.println(res + "개의 행이 수정 되었습니다.");
			} else {
				System.out.println("수정 실패했습니다.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			dbClose(conn, stmt, null);

		}

	}

	/**
	 * D:Delete() - 삭제하는 메소드 접근지정자 : publics param : 삭제될 키값 return :없음
	 * 
	 * @author smart17
	 *
	 */
	public void delete(ExamVO vo) {

		StringBuffer sql = new StringBuffer();

		sql.append(" DELETE FROM exam ");
		sql.append(" WHERE num = ? ");

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			

//			2. DB연결(DriverManager.getConnection())
			conn = getConn();

//			3. SQL문작성(Statement, PrepareStatement) - sql직접 실행하거나, 값 설정하고 실행하거나 / PrepareStatement을 주로 사용, Statement는 해킹의 우려가 있다.
			stmt = conn.prepareStatement(sql.toString());

			stmt.setInt(1, vo.getNum());

//			4. SQL문실행(executeQuery(), executeUpdate())
			int res = stmt.executeUpdate();

			if (res > 0) {
				System.out.println(res + "개의 행이 삭제 되었습니다.");
			} else {
				System.out.println("삭제 실패했습니다.");
			}
//			5. Select문 만 ResultSet 객체를 반환한다. 나머지는 int를 반환한다.

		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			// 6. 닫기(close())
			
			dbClose(conn, stmt, null);
		
		}
	}
}

			
		
		

	


