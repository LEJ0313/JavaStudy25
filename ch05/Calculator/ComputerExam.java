package ch05.Calculator;

public class ComputerExam {

	public static void main(String[] args) {
		int r = 10; //10 값을 실수로 전달
		
		Calculator cal = new Calculator(); //3.14159값으로 계산
		System.out.println("원면적 : " + cal.areaCircle(r));
		System.out.println(); // 부모 객체에 대한 원면적 계산값
		
		Computer com = new Computer(); //Math.PI값으로 메소드 재정의
		System.out.println("원면적 : " + com.areaCircle(r));
		System.out.println(); // 자식 객체에 대한 원면적 계산값

	}//main 메서드 종료

}//class 종료
