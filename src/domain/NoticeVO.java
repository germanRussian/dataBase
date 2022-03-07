package domain;
/**
 * 
 *  데이터베이스 연동 시험 - 이종혁
 * 
 */
import java.sql.Date;

public class NoticeVO {
	
	//필드
	private int no;
	private String title;
	private String content;
	private Date inputDate;
	
	//디폴트 생성자
	public NoticeVO() {
		
	}

	//필드를 활용한 생성자	
	public NoticeVO(int no, String title, String content, Date inputDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.inputDate = inputDate;
	}

	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", title=" + title + ", content=" + content + ", inputDate=" + inputDate + "]";
	}

	
	//get, set,
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
	
	
	
	
	

}
