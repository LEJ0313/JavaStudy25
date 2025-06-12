package mbcboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.BoardDAO;
import mbcboard.dto.BoardDTO;
import mbcboard.dto.MemberDTO;

public class BoardService {
	// dao와 dto를 사용하여 부메뉴와 CRUD를 처리한다.
	
	//필드
	public BoardDAO boardDAO = new BoardDAO(); // 빈객체 생성
	// 1단계 ~ 2단계가 수행 된다.
	// 1단계 : Connect 객체를 사용하여 ojdbc6.jar를 생성
	// 2단계 : url, id, pw, sql 쿼리문을 작성한다.
	
	// 생성자
	
	
	// 메서드 (부메뉴, 생성, 모두보기, 1개보기, 수정하기, 삭제하기)
	public void subMenu(Scanner inputStr, MemberDTO session) throws SQLException {
		boolean subRun = true ;
		while(subRun) {
			System.out.println("MBC아카데미 게시판 서비스 입니다.");
			System.out.println("1. 모두보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 자세히 보기");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
			System.out.println("6. 나가기");
			System.out.print(">>>");
			String subSelect = inputStr.next();
			
			switch(subSelect) {
			case "1" :
				System.out.println("모든 게시글 보기");
				selectAll(boardDAO); // selectAll 메서드 생성
				break ;
			case "2" :
				System.out.println("게시글 작성메서드로 진입합니다.");
				insertBoard(boardDAO, inputStr, session); 
				break ;
			case "3" :
				System.out.println("게시글 자세히 보기");
				readOne(inputStr);
				break ;
			case "4" :
				System.out.println("게시글 수정메서드로 진입합니다.");
				modify(inputStr, session);
				break ;
			case "5" :
				System.out.println("게시글 삭제메서드로 진입합니다.");
				deleteOne(session);
				break ;
			case "6" :
				System.out.println("게시글 보기 종료");
				subRun = false ;
				break ;
			}// switch문 종료(부메뉴)
			
			
			
			
		}//while문 종료(부메뉴)
		
	}


	private void deleteOne(MemberDTO session) throws SQLException {
		// 게시물의 번호를 받아 삭제한다.
		System.out.println("삭제하려는 게시글의 번호를 입력하세요");
		Scanner inputInt = new Scanner(System.in);
		System.out.print(">>>");
		int selectBno = inputInt.nextInt();
		boardDAO.deleteOne(selectBno);
		
	}


	private void modify(Scanner inputStr, MemberDTO session) throws SQLException {
		// 제목을 찾아서 내용을 수정한다.
		System.out.println("수정하려는 게시글의 제목을 입력하세요!");
		System.out.print(">>>");
		String title = inputStr.next();
		
		boardDAO.modify(title, inputStr);
		System.out.println("=====끝=====");
		
	}


	private void readOne(Scanner inputStr) throws SQLException {
		// 제목을 입력하면 내용이 보이도록 select 처리
		System.out.println("보고싶은 게시글의 제목을 입력하세요!");
		System.out.print(">>>");
		String title = inputStr.next();
		
		boardDAO.readOne(title); //boardDAO 패키지에 readOne 메서드로 title입력값이 넘어감
		System.out.println("========끝=========");
		
	}


	private void insertBoard(BoardDAO boardDAO, Scanner inputStr, MemberDTO session) throws SQLException {
		// 키보드로 입력한 데이터를 dto를 사용하여 데이터베이스에 insert하자.
		BoardDTO boardDTO = new BoardDTO(); //빈객체 생성
		System.out.print("작성자 : ");
		boardDTO.setBwriter(inputStr.next());
		
		System.out.print("제목 : ");
		boardDTO.setBtitle(inputStr.next());
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용 : ");
		boardDTO.setBcontent(inputLine.nextLine()); // 띄어쓰기가 있는 문장 nextLine 사용
		
		boardDAO.insertBoard(boardDTO); // 위에서 만든 객체를 DAO에게 전달
		System.out.println("==============insertBoard메서드 종료=========");
		
	}


	private void selectAll(BoardDAO boardDAO) throws SQLException {
		// dao 에게 전체보기 하는 서비스를 제공한다.
		System.out.println("========================");
		System.out.println("=====MBC게시판목록입니다=====");
		boardDAO.selectAll(); // dao 에 selectAll 메서드 생성해서 연결
		System.out.println("========================");
		
	}
	
	
	
	
	
	
}
