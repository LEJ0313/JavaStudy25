package ch05.webboard.DTO;

public class BoardDTO {
	//필드
	//작성일, 작성자, 제목, 카테고리, 내용
	protected int day;
	protected String name;
	protected String title;
	protected String category;
	protected String content;
	
	
	//생성자
	public BoardDTO(int day, String name, String title, String category, String content) {
		super();
		this.day = day;
		this.name = name;
		this.title = title;
		this.category = category;
		this.content = content;
	}
	
	public BoardDTO() {//기본생성자
		
	}

	
	//게터 세터 메소드
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
	
	
}
