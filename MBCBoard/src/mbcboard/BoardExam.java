package mbcboard;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dto.MemberDTO;
import mbcboard.service.BoardService;
import mbcboard.service.MemberService;

public class BoardExam {
	// 필드
	public static Scanner inputStr = new Scanner(System.in);
	
	public static MemberDTO session = null;
	
	//생성자 -> static 블럭 사용
	
	
	//메서드
	public static void main(String[] args) throws SQLException {
		// mbc 게시판용 jdbc 테스트
		// dto : 객체를 담당한다.
		// dao : 데이터베이스에서 연동을 담당한다.
		// service : 부메뉴와 서비스를 담당한다.
		boolean run = true ;
		
		while(run) {
			System.out.println("==============================");
			System.out.println("MBC 자유 게시판입니다.");
			System.out.println("1. 회원");
			System.out.println("2. 게시판");
			System.out.println("3. 종료");
			System.out.print(">>>");
			
			String select = inputStr.next(); 
			
			switch(select) {
			case "1" :
				System.out.println("================================");
				System.out.println("회원용 서비스로 진입합니다.");
				System.out.println("================================");
				MemberService memberService = new MemberService(); // 빈 객체 생성
				memberService.memberMenu(inputStr, session); 
				// 다른 패키지에 있는 서비스를 호출함
				break;
			case "2" :
				System.out.println("================================");
				System.out.println("게시판 서비스로 진입합니다.");
				System.out.println("================================");
				BoardService boardService = new BoardService(); //빈 객체 생성
				boardService.subMenu(inputStr, session); // 다른 패키지에 있는 서비스를 호출함
				break;
			case "3" :
				System.out.println("자유게시판 프로그램을 종료합니다.");
				run = false ;
				break ;
				default : 
					System.out.println("1~3까지만 입력 바랍니다.");
				
			}//switch문 종료
			
			
		}//while문 종료
		

	}// main 메서드 종료

}//class 종료



