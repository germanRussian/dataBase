package test;

import java.sql.Date;

import dao.ExamDAO;
import dao.ExamDAO2;
import domain.SampleSP;

public class Test1 {

	public static void main(String[] args) {
		

		
//		ExamDAO2 aaa = new ExamDAO2();
//		aaa.create(null);
		//aaa.read();
		//aaa.update();
		//aaa.delete();
		
		
		ExamDAO2 aaa = new ExamDAO2();
		SampleSP Createvo = new SampleSP(1, "Crew1", new Date(System.currentTimeMillis()));
//		 System.out.println(Createvo);
		aaa.create(Createvo);  // 내용 생성하기

	}

}
