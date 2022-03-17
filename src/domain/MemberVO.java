package domain;

import java.sql.Timestamp;

/**
 * 
 * 
 * 게시판 만들기
 * @author smart11
 *
 */


public class MemberVO {

	// 필드
	private String id;
	private String pw;
	private String uname;
	private String zipcode;
	private String address;
	private String address_detail;
	private Timestamp regdate;

	// 디폴트 생성자
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 필드 활용 생성자
	public MemberVO(String id, String pw, String uname, String zipcode, String address, String address_detail,
			Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.uname = uname;
		this.zipcode = zipcode;
		this.address = address;
		this.address_detail = address_detail;
		this.regdate = regdate;
	}

	// 투 스트링
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", uname=" + uname + ", zipcode=" + zipcode + ", address="
				+ address + ", address_detail=" + address_detail + ", regdate=" + regdate + "]";
	}

	// 갯 샛 메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

}
