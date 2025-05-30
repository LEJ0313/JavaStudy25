package ch04.marioKart.dto;

public class CharacterDTO {

	// 필드
	public String name; // 케릭터명
	public double weight; // 무게
	public double speed; // 속도
	public double acceleration; // 가속
	public double handling; // 핸들링
	public double friction; // 마찰력

	// 기본생성자 -> new CharacterDTO();
	// 사용자가 생성자를 만들면 기본생성자는 자동으로 만들지 않는다.
	
	// 생성자 -> 객체 생성시 값을 넣으면서 생성한다.
	public CharacterDTO(String name, double weight, double speed, 
			double acceleration, double handling, double friction) {
		// CharacterDTO characterDTO = new CharacterDTO(파라미터);
		this.name = name;
		this.weight = weight;
		this.speed = speed;
		this.acceleration = acceleration;
		this.handling = handling;
		this.friction = friction;
	}

	// 메서드

}
