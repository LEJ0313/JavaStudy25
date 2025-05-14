package ch02;

import java.util.Scanner;

public class SwitchAllExam {

	public static void main(String[] args) {
		
		//input = sc.next() -> 단어(문자열)

		
		
		
		Scanner inChar = new Scanner(System.in) ; //Char용 객체 생성
		Scanner input = new Scanner(System.in) ; 
		System.out.print("당신의 아이디를 입력해주세요. >>> ");
		
		String gradeStr = inChar.next() ;
		
		//System.out.println("검증 코드용 (1줄) : " + gradeStr); //테스트
		
		switch(gradeStr) {
		case "이은진" : 
		System.out.println(gradeStr + "님 로그인 되었습니다.");
		System.out.println("======================");
		System.out.println("======엠비씨아카데미======");
		System.out.println("=====성적처리 프로그램=====");
		System.out.println("======================");
		System.out.println("a. 성적 등록");
		System.out.println("b. 성적 삭제");
		System.out.println("c. 성적 계산");
		System.out.println("z. 프로그램 종료");
		System.out.print("(a~z)>>>");
		
		char select = input.next().charAt(0);
			
		switch(select) {
							
		case 'a' :
		case 'A' :
			System.out.println("성적 등록 메뉴로 입장하셨습니다."); //1번 메뉴 입장;
			break ; //a메뉴 멈춤
			
		case 'b' : 
		case 'B' : 
			System.out.println("성적 삭제 메뉴로 입장하셨습니다."); //2번 메뉴 입장
			break ; //b메뉴 멈춤
			
		case 'c' :  
		case 'C' : 
			System.out.println("성적 계산 메뉴로 입장하셨습니다.");//3번 메뉴 입장
			System.out.println("1. 평균 계산");
			System.out.println("2. 등급 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("(1~3)>>>");
			int subselect = input.nextInt();
			switch(subselect) {
			
			case 1 : 				
				System.out.println("국어 점수를 입력하세요.");
				System.out.print(">>>");
				int kor = input.nextInt() ; 
				if (kor < 0 || kor > 100) {
					
				}
				
				System.out.println("영어 점수를 입력하세요.");
				System.out.print(">>>");
				int eng = input.nextInt();
				if (eng < 0 || eng > 100) {
					
				}
				
				System.out.println("수학 점수를 입력하세요.");
				System.out.print(">>>");
				int mat = input.nextInt();
				if (mat < 0 || mat > 100) {
					
				}
				int total = kor + eng + mat ;
				double avg = (double)total /3 ;
				System.out.println("총점 : " + total + "입니다.");
				System.out.println("평균 : " + avg + "입니다.");
				System.out.println("프로그램을 종료합니다.");
				break ;				
				
			case 2 : 
				System.out.println("당신의 점수를 입력하세요.");
				System.out.print(">>>");
				int score = input.nextInt();
				
			if (score > 0 && score <=100) {
				if (score >= 90) {// 90보다 크거나 같으면
					System.out.println(gradeStr + "님이 입력하신 점수가 90점 이상입니다.");
					System.out.println("점수 : " + score + " : 등급 (A)");
				} else if (score >= 80) {
					System.out.println(gradeStr + "님이 입력하신 점수가 89~80점 이상입니다.");
					System.out.println("점수 : " + score + " : 등급 (B)");
				} else if (score >= 70) {
					System.out.println(gradeStr + "님이 입력하신 점수가 79~70점 이상입니다.");
					System.out.println("점수 : " + score + " : 등급 (C)");
				} else if (score >= 60) {
					System.out.println(gradeStr + "님이 입력하신 점수가 69~60점 이상입니다.");
					System.out.println("점수 : " + score + " : 등급 (D)");
				} else {
					System.out.println(gradeStr + "님이 입력하신 점수가 낮아 등급 F로 결정됨.");
					System.out.println("점수 : " + score + " : 등급 (F)");
				}//정상값이 입력되었을때 실행문
				
			} else {
				System.out.println(gradeStr + "님 입력값을 다시 확인해주세요.");
				System.out.println("현재 입력값은 " + score + "입니다.");
			}//다른값이 입력되었을때 실행문
			System.out.println("프로그램을 종료합니다.");
			break ;
				
			case 3 :
				System.out.println("프로그램을 종료합니다.");
				break ;
				
				default : 
					System.out.println("1~2 값만 입력해주세요.");
					System.out.println("프로그램을 다시 실행해주세요.");
				
			}//성적 계산 메뉴 종료
			
			break ; // c메뉴 멈춤
			 
		case 'z' : 
		case 'Z' :
			System.out.println("프로그램을 종료합니다."); //4번 메뉴 입장
			break ; // z메뉴 멈춤
			
		
			
		}//switch문(서브메뉴) 종료2				
			
		}//switch문(전체메뉴) 종료1

	}//main 메서드 종료

}//class 종료
