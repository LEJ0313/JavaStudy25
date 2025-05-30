package test;

import java.util.Scanner;

import test.Service.SchoolService;

public class TestExam {
	
			

	public static void main(String[] args) {
		
		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		
		boolean run = true;
		while(run) {
			System.out.println("===엠비씨교사용홈페이지===");
			System.out.println("1. 학생 성적관리");
			System.out.println("2. 전교생 목록");
			System.out.println("3. 학생 수정");
			System.out.println("4. 학생 졸업처리");
			System.out.println("5. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch(select) {
			case "1" :
				System.out.println("학생 성적관리 메뉴입니다.");
				SchoolService schoolService = new SchoolService();
				schoolService.menu(inputStr, inputInt, null);
				break ;
			case "2" :
				System.out.println("전교생 목록보기 메뉴입니다.");
				break ;
				
			case "3" :
				System.out.println("학생 수정 메뉴입니다.");
			break ;
			
			case "4" :
				System.out.println("학생 졸업처리 메뉴입니다.");
				break ;
				
			case "5" :
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break ;
				default : 
					System.out.println("1~5까지만 입력해주세요.");
			}//switch문 종료
			
		}//whiles문 종료
		
		
		
		

	}//main 메서드 종료

}//class 종료
