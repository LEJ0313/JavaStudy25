package ch01;

public class VariabelExam {

	public static void main(String[] args) {
		
		int mach ;
		int distance ;
		mach = 340 ;
		distance = mach * 60 * 60 ; // 음속 m/s로 계산함
		
		System.out.println("소리가 1시간동안 가는 거리");
		System.out.println(distance + "m");
		
		double radius ; // 실수 타입의 radius 변수 선언
		double area ; // 실수 타입의 area 변수 선언
		// 실수 타입은 소수점이 있다 (double = 소수점 처리)
		
		radius = 10 ; // 초기값이 정수이지만 double 때문에 소수점(실수)으로 변환됨
		area = radius * radius * 3.14 ; // 원의 넓이 계산
		
		System.out.print("반지름이 " + radius + "인");
		System.out.println(" 원의 넓이 = " + area);
		// ln = 줄내리기 

	}

}
