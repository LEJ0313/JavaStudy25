package ch05.webboard.DTO;

public class fileBoardDTO extends BoardDTO{
	
	public fileBoardDTO(int day, String name, String title, String category, String content) {
		this.day = day;
		this.name = name;
		this.title = title;
		this.category = category;
		this.content = content;
	}
	
	public fileBoardDTO() {
		//기본생성자
	}

}
