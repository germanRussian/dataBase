package test;

import dao.MemberDAO;
import domain.MemberVO;

public class MemberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberVO mvo = new MemberVO();
		mvo.setId("hyuk1");
		mvo.setPw("****");
		mvo.setUname("이종혁");
		
		//System.out.println(mvo);
		
		new MemberDAO().create(mvo);
		
		
		
	}

}
