package mbcboard.dto;

public class MemberDTO {
	
	// 필드
	private String id;
	private String pw;
	private int mno;
	private String email;
	private String bwriter;
	
	// 생성자
	public MemberDTO() {
		
	}
	
	public MemberDTO(int mno, String id, String pw, String email, String bwriter) {
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.bwriter = bwriter;
	}
	
	
	// 메서드
			
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public int getMno() {
		return mno;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	
	

	
	
}
