package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class BoardDTO implements Serializable{
	


	// 필드
	private String sfl;//검색종류 탭
	private String keword;//검색어
	
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(String sfl, String keword) {
		super();
		this.sfl = sfl;
		this.keword = keword;
	}

	@Override
	public String toString() {
		return "BoardDTO [sfl=" + sfl + ", keword=" + keword + "]";
	}

	public String getSfl() {
		return sfl;
	}

	public void setSfl(String sfl) {
		this.sfl = sfl;
	}

	public String getKeword() {
		return keword;
	}

	public void setKeword(String keword) {
		this.keword = keword;
	}
	
	
	
	
	
	
	
	
	
//	private int board_id;
//	private String writer;
//	private String title;
//	private String content;
//	private Timestamp regdate;
//	private int hit;
//	
//	
//	public BoardDTO() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public BoardDTO(int board_id, String writer, String title, String content, Timestamp regdate, int hit) {
//		super();
//		this.board_id = board_id;
//		this.writer = writer;
//		this.title = title;
//		this.content = content;
//		this.regdate = regdate;
//		this.hit = hit;
//	}
//
//
//	@Override
//	public String toString() {
//		return "BoardDTO [board_id=" + board_id + ", writer=" + writer + ", title=" + title + ", content=" + content
//				+ ", regdate=" + regdate + ", hit=" + hit + "]";
//	}
//
//
//	public int getBoard_id() {
//		return board_id;
//	}
//
//
//	public void setBoard_id(int board_id) {
//		this.board_id = board_id;
//	}
//
//
//	public String getWriter() {
//		return writer;
//	}
//
//
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//
//
//	public String getTitle() {
//		return title;
//	}
//
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//
//	public String getContent() {
//		return content;
//	}
//
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//
//	public Timestamp getRegdate() {
//		return regdate;
//	}
//
//
//	public void setRegdate(Timestamp regdate) {
//		this.regdate = regdate;
//	}
//
//
//	public int getHit() {
//		return hit;
//	}
//
//
//	public void setHit(int hit) {
//		this.hit = hit;
//	}
//	
//	
	
	
	
	
	
	

	
}
