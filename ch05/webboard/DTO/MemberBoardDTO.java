package ch05.webboard.DTO;

public class MemberBoardDTO extends BoardDTO{
	
	
	
	public MemberBoardDTO(int day, String name, String title, String category, String content) {
		this.day = day;
		this.name = name;
		this.title = title;
		this.category = category;
		this.content = content;
	}

	public MemberBoardDTO() {
		//기본생성자
	}
	
}
