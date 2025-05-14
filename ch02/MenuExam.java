package ch02;

import java.util.Scanner;

public class MenuExam {

	public static void main(String[] args) {
		
		Scanner inputInt = new Scanner(System.in); //정수용 스캐너 생성
		Scanner inputChar = new Scanner(System.in); //문자용 스캐너 생성				
		
		boolean run = true ; //무한반복용 변수 생성
		
		while(run) {			
			System.out.println("=====엠비씨성적처리=====");
			System.out.println("1. 교직원 관리");
			System.out.println("2. 학생 관리");
			System.out.println("3. 성적 관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("(0~3까지 입력하세요) >>> ");
			int selectInt = inputInt.nextInt(); //숫자입력이 가능하게 해주는 명령어
				
			switch(selectInt) {//키보드로 입력된 숫자를 판단하여 분기 결정
			
			case 1 : 
				boolean subrun = true ;
				
				while (subrun) {
					System.out.println("==교직원관리 메뉴로 진입==");
					System.out.println("a. 교직원등록");
					System.out.println("b. 교직원 보기");
					System.out.println("c. 교직원 수정");
					System.out.println("d. 교직원 삭제");
					System.out.println("z. 교직원관리 메뉴 종료");
					System.out.print("(a~z까지 입력하세요.) >>> ");
				char subSelect = inputChar.next().charAt(0);
				//문자열로 입력된 값 중에 맨 앞문자만 subSelect 변수에 넣음
				//위에서 입력받은 알파벳을 처리
				switch(subSelect) {
				case 'A' :
				case 'a' :
					System.out.println("교직원등록 메뉴로 진입했습니다.");
					break ;
					
				case 'B' :
				case 'b' : 
					System.out.println("교직원보기 메뉴로 진입했습니다.");
					break ;
					
				case 'C' :
				case 'c' : 
					System.out.println("교직원수정 메뉴로 진입했습니다.");
					break ;
					
				case 'D' :
				case 'd' :
					System.out.println("교직원삭제 메뉴로 진입했습니다.");
					break ;
					
				case 'Z' :
				case 'z' : 
					System.out.println("교직원메뉴를 종료합니다.");
					subrun = false ;
					break ;
					default :
						System.out.println("a~z까지 입력해주세요.");
					
				}//교직원관리 switch문 종료		
				 
				}//교직원관리 while문 종료
				break ;
				
			case 2 : 
				boolean subrun2 = true ;
				
				while (subrun2) {
					System.out.println("==학생관리 메뉴로 진입==");
					System.out.println("a. 학생등록");
					System.out.println("b. 학생보기");
					System.out.println("c. 학생수정");
					System.out.println("d. 학생삭제");
					System.out.println("z. 학생관리 메뉴 종료");
					System.out.print("(a~z까지 입력하세요)>>>");
					char subSelect = inputChar.next().charAt(0);
				switch (subSelect) {
					
					case 'A' :
					case 'a' :
						System.out.println("학생등록 메뉴에 진입했습니다.");
						break ;
						
					case 'B' :
					case 'b' :
						System.out.println("학생보기 메뉴에 진입했습니다.");
						break ;
						
					case 'C' :
					case 'c' : 
						System.out.println("학생수정 메뉴에 진입했습니다.");
						break ;
						
					case 'D' :
					case 'd' :
						System.out.println("학생삭제 메뉴에 진입했습니다.");
						break ;
						
					case 'Z' :
					case 'z' : 
						System.out.println("학생메뉴를 종료합니다.");
						subrun2 = false ;
						break ;
						default : 
							System.out.println("a~z까지 입력해주세요.");
					
					}//학생관리 switch문 종료
					
				}//학생관리 while문 종료
				break ;
			
			case 3 : 
				boolean subrun3 = true ;
				
				while(subrun3) {
					System.out.println("==성적관리 메뉴에 진입=="); 
					System.out.println("a. 평균 계산");
					System.out.println("b. 등급 확인");
					System.out.println("z. 성적관리 메뉴 종료");
					System.out.print("(a~z까지 입력하세요)>>>");
					char subSelect = inputChar.next().charAt(0);
					
				switch(subSelect) {
											
				case 'a' : //평균계산 메뉴
				case 'A' :
					System.out.println("국어 점수를 입력하세요.");
					System.out.print(">>>");
					int kor = inputInt.nextInt();
					if(kor < 0 || kor > 100) {
						
					}
					System.out.println("영어 점수를 입력하세요.");
					System.out.print(">>>");
					int eng = inputInt.nextInt();
					if(eng < 0 || eng > 100) {
						
					}
					System.out.println("수학 점수를 입력하세요.");
					System.out.print(">>>");
					int mat = inputInt.nextInt();
					if(mat < 0 || mat > 100) {
						
					}
					int total = kor + eng + mat ;
					double avg = total /3 ;
					System.out.println("총점 : " + total);
					System.out.println("평균 : " + avg);
					System.out.println("평균계산 메뉴를 종료합니다.");					
					break ;
					
				case 'b' : //등급확인메뉴
				case 'B' : 
					System.out.println("당신의 점수를 입력하세요.");
					System.out.print(">>>");
					int score = inputInt.nextInt();
					
				if (score > 0 && score <= 100) {
					if(score >= 90) {
						System.out.println("당신이 입력하신 점수가 90점 이상입니다.");
						System.out.println("점수 : " + score + ": 등급 (A)");
					}else if (score >= 80 ) {
						System.out.println("당신이 입력하신 점수가 89~80점 이상입니다.");
						System.out.println("점수 : " + score + ": 등급 (B)");
					}else if (score >= 70 ) {
						System.out.println("당신이 입력하신 점수가 79~70점 이상입니다.");
						System.out.println("점수 : " + score + ": 등급 (C)");
					}else if (score >= 60 ) {
						System.out.println("당신이 입력하신 점수가 69~60점 이상입니다.");
						System.out.println("점수 : " + score + ": 등급 (D)");
					}else {
						System.out.println("당신의 점수가 낮아 F등급으로 결정됬습니다.");
						System.out.println("점수 : " + score + ": 등급 (F)");
					}//등급확인 실행문
					
				}else {
					System.out.println("입력값을 다시 확인해주세요.");
					System.out.println("현재 입력값은" + score + "입니다.");
				}//다른값이 입력되었을때 실행문
				System.out.println("등급확인 메뉴를 종료합니다.");
				break ;
					
				case 'Z' : //종료
				case 'z' : 
					System.out.println("성적관리 메뉴를 종료합니다.");							
					subrun3 = false ;
					break ;
					default : 
						System.out.println("(a~c까지 입력하세요.) >>>");
					
				}//성적관리 switch문 종료
										
				}//성적관리 while문 종료				
			
				break ;
			case 0 : 
				System.out.println("===프로그램 종료===");
				run = false ;
				break ;
				
				default : 
					System.out.println("0~3까지 숫자를 입력하세요.");
					break ;
				
			}//switch문 종료
			
		}//엠비씨 성적처리 메뉴 while문 종료								

	}//main 메서드 종료

}//class 종료
