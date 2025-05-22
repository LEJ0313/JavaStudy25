package ch04;

import java.util.Scanner;

public class CarExam {

	public static void main(String[] args) {
		// 자동차 주 실험 프로그램
		Scanner input = new Scanner(System.in); //키보드로 입력받을수있는 스캐너 생성
		
		int speed = 0; //차량 속도
		final int MAXSPEED = 300;
		final int MINSPEED = 0;
				
		boolean run = true ;
		
		
		System.out.println("===차량 정보 입력===");
		Car myCar = new Car(); //기본생성자로 객체 생성
		//생성시 speed와 rpm과 oil이 기본값으로 생성됨
		
		System.out.print("제조회사 : ");
		myCar.company = input.next();
		
		System.out.print("모델 : ");
		myCar.model = input.next();
		
		System.out.print("색상 : ");
		myCar.color = input.next();
		
		while(run) {
			System.out.println("1. 차량 정보 확인");
			System.out.println("2. 차량 시동 걸기");
			System.out.println("3. 차량 주행 시작");
			System.out.println("4. 차량 주행 종료");
			System.out.print("(1~4)>>>");
			String select = input.next();
			
			switch(select) {
			case "1" : 
				System.out.println("차량명 : " + myCar.company);
				System.out.println("모델 : " + myCar.model);
				System.out.println("색상 : " + myCar.color);
				break ;
				
			case "2" : 
				System.out.println("차량에 시동이 걸렸습니다.");
				myCar.start();			
				break ;
				
			case "3" :
				boolean run1 = true;
				while(run1) {
				System.out.println("차량 주행을 시작합니다.");
				System.out.println("1. 액셀");
				System.out.println("2. 브레이크");
				System.out.println("3. 뒤로가기");
				System.out.print("(1~3)>>>");
				String subselect = input.next();
				switch(subselect) {
				
				case "1" :
					System.out.println("가속을 진행합니다.");
					speed += 30; //30씩 가속
					if(speed >= MAXSPEED) {//현재속도가 최고속도보다 크거나 같으면
						speed = MAXSPEED;//300이상 출력 안됨
					
					}//가속if문 종료
					System.out.println("현재속도 : " + speed + "km/s입니다.");
					 break ;
					 					 
				case "2" :
					System.out.println("감속을 진행합니다.");
					
					speed -= 10; //10씩 감속
					if(speed <= MINSPEED) {//현재속도가 최저속도보다 작거나 같으면
						speed = MINSPEED; //0이하 감속 안됨
						
					}//감속 if문 종료
					
					
					System.out.println("현재속도 : " + speed + "km/s입니다.");
					break ;
					
				case "3" :
					System.out.println("이전메뉴로 돌아갑니다.");
					run1 = false ;
					break ;					
					
					default : 
						System.out.println("1~3까지만 입력해주세요.");
						
				}//차량주행 switch문 종료
				
				}//차량주행 while문 종료
				break ;
				
			case "4" :
				System.out.println("차량 주행을 종료합니다...");
				run = false;
				break ;
				
				default : 
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				
				
				
				
			}//메인메뉴 switch문 종료
			
		}//메인메뉴 while문 종료
		
		

	}//main 메서드 종료

}//class 종료
