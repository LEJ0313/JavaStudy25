package ch05.webboard.DTO;

public class FreeBoardDTO extends BoardDTO{//BoardDTO를 부모로 만듬

	public FreeBoardDTO(int day, String name, String title, String category, String content) {
		this.day = day;
		this.name = name;
		this.title = title;
		this.category = category;
		this.content = content;
		
	}
	
	public FreeBoardDTO() {
		//기본생성자
	}
		
	
}
