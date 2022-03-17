package test;

import java.util.Iterator;
import java.util.List;

import dao.BoardDAO;
import domain.BoardDTO;
import domain.BoardVO;

public class BoardTest {

	public static void main(String[] args) {
		
		//1.테이블[member]에 임의의 데이터를 1건 등록하시오.
//		BoardVO bvo = new BoardVO();
//		bvo.setWriter("123456");
//		bvo.setTitle("JAVA란 무엇인가-하");
//		bvo.setContent("JAVA의 시작");
////		System.out.println(bvo.toString());
//		new BoardDAO().create(bvo);
		
		
		
		
		//2.게시판을 조회하는 DML명령어를 작성하시오.
//		BoardVO bvo = null;
//		List<BoardVO> list = new BoardDAO().read();
//		Iterator<BoardVO> it = list.iterator();
//		while(it.hasNext()) {
//			
//			bvo = it.next();
//			System.out.printf("%d\t %s\t %s\t %s\t %s\t %d\n",
//			
//			bvo.getBoard_id(),
//			bvo.getTitle(),
//			bvo.getWriter(),
//			bvo.getContent(),
//			bvo.getRegdate(),
//			bvo.getHit());
//		}
		
		//3.게시판에서 제목[title]을 임의의 검색어로 조회하시오.
//		BoardDTO bdto = new BoardDTO();
//		bdto.setSfl("title|content");
//		bdto.setKeword("하");
//		
//		BoardVO bvo = null;
//		List<BoardVO> list = new BoardDAO().read(bdto);
//		Iterator<BoardVO> it = list.iterator();
//		
//		while(it.hasNext()) {
//			
//			bvo = it.next();
//			System.out.printf("%d\t %s\t %s\t %s\t %s\t %d\n",
//			
//			bvo.getBoard_id(),
//			bvo.getTitle(),
//			bvo.getWriter(),
//			bvo.getContent(),
//			bvo.getRegdate(),
//			bvo.getHit());
//		}
		
		//4. 게시판에서 임의의 한 개 게시글을 선택하여 글내용을 조회하시오.
		
		BoardVO vo = new BoardVO();
		vo.setBoard_id(3);
		
		
		BoardVO bvo = new BoardDAO().read(vo);
		
		if(bvo != null) {
			
			
			System.out.printf("%d\t %s\t %s\t %s\t %s\t %d\n",
			
			bvo.getBoard_id(),
			bvo.getTitle(),
			bvo.getWriter(),
			bvo.getContent(),
			bvo.getRegdate(),
			bvo.getHit());
			
		}else 
			System.out.println("해당 글이 없습니다.");
		
		
		
		

	}

}
