package test;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import dao.ExamDAO;
import dao.ExamDAO2;
import domain.ExamVO;
import domain.SampleVO;

public class Test1 {

	public static void main(String[] args) {
		

		//1. 객체 생성, 메소드 활용하여 작동
//		ExamDAO2 aaa = new ExamDAO2();
//		aaa.create();
//		aaa.read();
//		aaa.update();
//		aaa.delete();
//		
		
		
		
		// 2. 생성자를 활용하여 데이터를 생성할 것이다.
//		ExamDAO2 aaa = new ExamDAO2();
//		SampleVO Createvo = new SampleVO(0, "Crew1", new Date(System.currentTimeMillis()));
////		System.out.println(Createvo);
//		aaa.create(Createvo);  // 내용 생성하기
		
		
		// 3. Read 내용 불러오기.(전체 내용을 가져오기)
//		ExamDAO2 aaa = new ExamDAO2();
//		List<SampleVO> list =  aaa.read();
//		Iterator<SampleVO> it = list.iterator();//배열 속에서 하나씩 꺼낼 수 있다.
//		while(it.hasNext()) {
//			SampleVO VO = it.next();
//			System.out.print(VO.getNum() + "\t");
//			System.out.print(VO.getStrData() + "\t");
//			System.out.println(VO.getSampleDate() + "\t");
//		}
		
		
		// 4. Read 내용 불러오기.(일부 내용을 선택하여 가져오기)
//		ExamDAO2 aaa = new ExamDAO2();
//		List<SampleVO> list =  aaa.read();
//		Iterator<SampleVO> it = list.iterator();//배열 속에서 하나씩 꺼낼 수 있다.
//		
//		SampleVO readVO = new SampleVO();
//		readVO.setNum(4);
//		
//		System.out.println(readVO);
//		SampleVO readVORes = aaa.read(readVO);
//
//		if (readVORes != null) {
//
//			SampleVO VO = it.next();
//			System.out.print(VO.getNum() + "\t");
//			System.out.print(VO.getStrData() + "\t");
//			System.out.println(VO.getSampleDate() + "\t");
//			
//		}

		
//		4번 5번 오류 
//		4번 Num 지정에 따라 출력이 안됨
//		5번 연도 표시 오류
		
		// 5. 생성자를 활용하여 수정할 것이다.
		//5-1방법
//		ExamDAO2 aaa = new ExamDAO2();
//		SampleVO updateVO = new SampleVO(4, "Crew233333", new Date(2022, 10, 12));				
//		aaa.update(updateVO);

		//5-2방법
//		ExamDAO2 aaa = new ExamDAO2();
//		SampleVO updateVO = new SampleVO();
//		updateVO.setNum(2); //내용 생성하기
//		updateVO.setStrData("Crew24444");
//		updateVO.setSampleDate(new Date(2022, 10, 12));
//		aaa.update(updateVO);
		
		
		// 6. 삭제를 해봅시다.
		ExamDAO2 aaa = new ExamDAO2();
		SampleVO deletevo = new SampleVO();
//		deletevo.setNum(6);
//		aaa.delete(deletevo);		
		
		
		int a = 10; //시작 번호
		int b = 13; //끝 번호
		
		for(int i= 0; i<= b-a; i++) {
			System.out.println(a+i);
			deletevo.setNum(a);
		}
		aaa.delete(deletevo);
		
		
		
				


	}

}