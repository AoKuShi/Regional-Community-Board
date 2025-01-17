package kr.ac.kopo.member.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MemberVO {
    private int memberNo; // MEMBER_NO
    private String memberId; // MEMBER_ID
    private String password; // MEMBER_PASSWORD
    private String name; // MEMBER_NAME
    private String email; // MEMBER_EMAIL
    private String area; // MEMBER_AREA
    private String startDate; // MEMBER_S_DATE
    private char isAdmin; // IS_ADMIN
    
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberVO(int memberNo, String memberId, String password, String name, String email, String area,
			String startDate, char isAdmin) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.area = area;
		this.startDate = startDate;
		this.isAdmin = isAdmin;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public char getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(char isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", memberId=" + memberId + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", area=" + area + ", startDate=" + startDate + ", isAdmin=" + isAdmin + "]";
	}
    
}
