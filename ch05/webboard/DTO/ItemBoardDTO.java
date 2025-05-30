package ch05.webboard.DTO;

public class ItemBoardDTO extends BoardDTO{
	
	public ItemBoardDTO(int day, String name, String title, String category, String content) {
		this.day = day;
		this.name = name;
		this.title = title;
		this.category = category;
		this.content = content;
	}
	
	public ItemBoardDTO() {
		//기본생성자
	}

}
