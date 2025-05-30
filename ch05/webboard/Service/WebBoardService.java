package ch05.webboard.Service;

import java.util.Scanner;

import ch05.webboard.DTO.FreeBoardDTO;

public class WebBoardService { //crud 생성
	//필드
	
	//생성자
	
	//메서드
	public void menu(Scanner inputInt, Scanner inputStr, FreeBoardDTO[] freeBoard) {
		boolean run = true;
		while(run) {
			System.out.println("--------------------");
			System.out.println("자유게시판 메서드입니다.");
			System.out.println("1. 게시물 등록");
			System.out.println("2. 게시물 목록");
			System.out.println("3. 게시물 수정");
			System.out.println("4. 게시물 삭제");
			System.out.println("5. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch(select) {
			case "1" :
				System.out.println("게시물등록 메서드로 진입합니다.");
				break ;
				
			case "2" : 
				System.out.println("게시물목록 메서드로 진입합니다.");
				break;
				
			case "3" :
				System.out.println("게시물수정 메서드로 진입합니다.");
				break;
				
			case "4" :
				System.out.println("게시물삭제 메서드로 진입합니다.");
				break;
				
			case "5" :
				System.out.println("종료하겠습니다.");
				run = false;
				
				default : 
					System.out.println("1~5까지만 입력해주세요.");
					break ;
			
			}//switch문 종료
			
		}//while문 종료
		
	}//menu메서드 종료

}
