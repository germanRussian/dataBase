package test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.ExamDAO;
import domain.ExamVO;

//import test.dao.simple2DAO;

public class Test {

	public static void main(String[] args) {

		// 1. 객체 생성, 메소드 활용하여 작동
//		simpleDAO dao = new simple2DAO();
//		ExamDAO dao = new ExamDAO();
//		dao.create();
//		//dao.read();
		//dao.update();
//		//dao.delete();

		
		
		
		
		
		// 2. 생성자를 활용하여 데이터를 생성할 것이다.
//		ExamDAO dao = new ExamDAO();
//		ExamVO Createvo = new ExamVO(0, "가변폭문자열", "고정폭문자열", 0.123, new Date(),
//				new Timestamp(System.currentTimeMillis()));
		// System.out.println(Createvo);
//		dao.create(Createvo);  // 내용 생성하기

		
		
		
		
		
		
		// 3. Read 내용 불러오기.(전체 내용을 가져오기)
//		ExamDAO dao = new ExamDAO();
//		List<ExamVO> list =  dao.read();
//		Iterator<ExamVO> it = list.iterator();//배열 속에서 하나씩 꺼낼 수 있다.
//		while(it.hasNext()) {
//			ExamVO vo = it.next();
//			System.out.println(vo.getNum() + "\t");
//			System.out.println(vo.getVarcharTest() + "\t");
//			System.out.println(vo.getCharTest() + "\t");
//			System.out.println(vo.getDoubleTest() + "\t");
//			System.out.println(vo.getDateTest() + "\t");
//			System.out.println(vo.getDateTimeTest() + "\t");
//		}

		
		
		
		// 4. Read 내용 불러오기.(일부 내용을 선택하여 가져오기)
//		ExamDAO dao = new ExamDAO();
//		ExamVO readVo = new ExamVO();
//		readVo.setNum(6);
//		System.out.println(readVo);
//		ExamVO readVoRes = dao.read(readVo);
//
//		if (readVoRes != null) {
//
//			System.out.println(readVoRes.getNum() + "\t");
//			System.out.println(readVoRes.getVarcharTest() + "\t");
//			System.out.println(readVoRes.getCharTest() + "\t");
//			System.out.println(readVoRes.getDoubleTest() + "\t");
//			System.out.println(readVoRes.getDateTest() + "\t");
//			System.out.println(readVoRes.getDateTimeTest() + "\t");
//
//		}

		
		
		
		
		// 5. 생성자를 활용하여 수정할 것이다.
//		
//		ExamVO updatevo = new ExamVO();
//		
//		ExamVO updatevo = new ExamVO(8, "바꿀값", "고정폭문자열", 123.456, new Date(),
//				new Timestamp(System.currentTimeMillis()));
//		
//		updatevo.setNum(10); //내용 생성하기
//		updatevo.setVarcharTest("바꿀값");
//		updatevo.setDoubleTest(123.456);
//		dao.update(updatevo);

		
		
		
		
		
		// 6. 삭제를 해봅시다.
//		ExamDAO dao = new ExamDAO();
//		ExamVO deletevo = new ExamVO();
//		deletevo.setNum(13);
////		deletevo.setVarcharTest("가변폭문자열");
//		dao.delete(deletevo);
////		한개씩만 지울수 있단다.
	}
}
