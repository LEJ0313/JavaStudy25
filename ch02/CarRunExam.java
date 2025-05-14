package ch02;

import java.util.Scanner;

public class CarRunExam {

	public static void main(String[] args) {
		//자동차 주행 프로그램 만들기
		// c -> 시동을 건다.(start)
		// r -> 계기판 정보 출력
		// u -> 주행
		// d -> 시동끄기 (end)
		
		Scanner input = new Scanner(System.in);
		
		boolean run = true ; //시동을 건다
		
		int speed = 0 ; //차량 속도
		
		final int MAXSPEED = 300 ; //최고속도 상수(변경안됨)
		final int MINSPEED = 0 ; //최저속도 상수(변경안됨)
		
		System.out.println("람보르기니가 입고 되었습니다.");
		System.out.println("시동을 켭니다.");
		System.out.println("현재 속도 : " + speed + "km/s");
		
		while(run) {
		//무한 반복 중 메뉴가 출력
			System.out.println("=================");
			System.out.println("0. 시동 종료");
			System.out.println("1. 액셀");
			System.out.println("2. 브레이크");
			System.out.println("3. 멀티미디어");
			System.out.println("4. 주유하기");
			System.out.println("=================");
			System.out.println("(0~4숫자만 입력)>>>");
			int select = input.nextInt();
			
			switch(select) {
			case 0 : 
				System.out.println("시동을 종료합니다.");
				run = false ;
				break ;
				
			case 1 : 
				System.out.println("가속을 진행합니다.");
				speed += 30 ;
				if(speed >= MAXSPEED) {//현재속도가 최고속도보다 크거나 같으면
					speed = MAXSPEED ;
				}//300이상 출력 안됨 case1 종료
				System.out.println("현재속도 : " + speed + "km/h");
				break ;
				
			case 2 :
				System.out.println("감속을 진행합니다.");
				speed -= 10 ;
				if(speed <= MINSPEED) {
					speed = MINSPEED ;
				}//case2 종료
				System.out.println("현재속도 : " + speed + "km/h");
				break ;
				
			case 3 :
				System.out.println("멀티미디어를 실행합니다.");
				break ;
				
			case 4 : 
				System.out.println("주유를 진행합니다.");
				break ;
				
				
			}//switch문 종료
						
		}//while문 종료				
				System.out.println("람보르기니 자동차가 사라집니다.");
	}//main 메서드 종료

}//class 종료
