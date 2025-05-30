package ch05.Calculator;

public class Computer extends Calculator{

	@Override
	double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}// 메소드 오버라이딩 진행
	
	
	

}
