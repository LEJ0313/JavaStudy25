package ch05.supersonic;

public class SuperSonicAirplane extends Airplane{
	// 자식 클래스
	public static final int NORMAL = 1; //일반비행
	public static final int SUPERSONIC = 2; //초음속비행
	//상수 선언(변하지 않는 값)
	
	public int flyMode = NORMAL ; //기본 비행 모드는 일반비행=1

	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		}else {
			super.fly();//부모에서 제공하는 fly메소드 호출
		}
		
	}
	
	
	

}
