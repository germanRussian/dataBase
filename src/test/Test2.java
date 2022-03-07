package test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import dao.ExamDAO;
import dao.ExamDAO2;
import dao.NoticeDAO;
import domain.ExamVO;
import domain.NoticeVO;
import domain.SampleVO;

public class Test2 {

	public static void main(String[] args) {

		

		// 2. 생성자를 활용하여 데이터를 생성할 것이다.
		NoticeDAO aaa = new NoticeDAO();
		NoticeVO Createvo = new NoticeVO(0, " JAVA web ", " JAVA ", new Date(System.currentTimeMillis()));
//		System.out.println(Createvo);
		aaa.create(Createvo);// 내용 생성하기
		
		// 3. Read 내용 불러오기.(전체 내용을 가져오기)
//		NoticeDAO aaa = new NoticeDAO();
//		List<NoticeVO> list =  aaa.read();
//		Iterator<NoticeVO> it = list.iterator();//배열 속에서 하나씩 꺼낼 수 있다.
//		while(it.hasNext()) {
//			NoticeVO VO = it.next();
//			
//			System.out.print(VO.getNo() + "\t");
//			System.out.print(VO.getTitle() + "\t");
//			System.out.print(VO.getContent() + "\t");
//			System.out.println(VO.getInputDate() + "\t");
//		}

		

		
		
		
		
		
		
		

	}

	

}
