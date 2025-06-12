package mbcboard.service;

import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.MemberDAO;
import mbcboard.dto.MemberDTO;

public class MemberService {
	// dao와 dto를 이용하여 부메뉴와 crud를 실행한다
	
	// 필드
	public MemberDAO memberDAO = new MemberDAO(); // 빈 객체 생성
	
	
	// 생성자
	
	
	// 메서드
	
	public MemberDTO memberMenu(Scanner inputStr, MemberDTO session) throws SQLException {
		
		
		boolean subRun1 = true;
		while(subRun1) {
			System.out.println("MBC 아카데미 회원용 서비스입니다.");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("5. 나가기");
			System.out.print(">>>");
			String subSelect1 = inputStr.next();
			
			switch(subSelect1) {
			case "1" : 
				System.out.println("================================");
				System.out.println("회원가입 메서드로 진입합니다.");
				createMember(memberDAO); // memberDAO에 createMember 메서드 생성
				break ;
			case "2" : 
				System.out.println("================================");
				System.out.println("로그인 메서드로 진입합니다.");
				session = loginMember(memberDAO, session); 
				// memberDAO에 loginMember 메서드 생성
				// memberDAO : DB 작업용 DAO 객체
				// session : 로그인한 회원의 정보
				break ;
			case "3" :
				System.out.println("================================");
				System.out.println("회원수정 메서드로 진입합니다.");
				updateMember(memberDAO, session);// memberDAO에 updateMember 메서드 생성
				// memberDAO : DB 작업용 DAO 객체
				// session : 로그인한 회원의 정보
				break; 
			case "4" :
				System.out.println("================================");
				System.out.println("회원탈퇴 메서드로 진입합니다.");
				deleteMember(memberDAO, session);// memberDAO에 deleteMember 메서드 생성
				// memberDAO : DB 작업용 DAO 객체
				// session : 로그인한 회원의 정보
			
				break;
			case "5" :
				System.out.println("================================");
				System.out.println("회원용 서비스에서 나가겠습니다.");
				subRun1 = false ;
				break ;
				default : 
					System.out.println("1~5까지만 입력해주세요.");
			
			
			}// 회원용 스위치문 종료
			
		}// 회원용 와일문 종료
		
		return session ;
		
	}


	private void deleteMember(MemberDAO memberDAO, MemberDTO session) {
		
		
		
		if (session == null) {
			System.out.println("로그인 정보가 없습니다.");		
		return;
		} 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("현재 접속중인 아이디 : " + session.getId());
	
	
		System.out.println("정말 탈퇴하시겠습니까? (Y/N)");
		System.out.print(">>>");
		String answer = scanner.nextLine();
		
		if(!answer.equalsIgnoreCase("y")) {
			System.out.println("회원 탈퇴가 취소되었습니다.");
			return;
		}
		
		
		String userId = session.getId();
		boolean success = memberDAO.delete(userId);
		
		
		
		if(success) {
			
			System.out.println("회원 탈퇴가 완료되었습니다.");
			
		}else {
			System.out.println("회원 탈퇴 실패. 다시 시도해주세요.");
		}
		
	}// 멤버 삭제 메서드 종료


	private void updateMember(MemberDAO memberDAO, MemberDTO session) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("====회원 정보 수정====");
		System.out.println("본인인증을 시작합니다.");
		
		System.out.print("아이디 : ");
		String id = scanner.nextLine();
		
		System.out.print("현재 비밀번호 : ");
		String pw = scanner.nextLine();
		
		MemberDTO member = memberDAO.loginMember(id, pw, session);
		if (member == null) {
			System.out.println("인증실패. 아이디 또는 비밀번호가 틀립니다.");
			System.out.println("다시 입력해주세요.");
			
			return;
		}
		
		System.out.println("===== 본인인증 완료 =====");
		System.out.print("새 비밀번호 입력 : ");
		String newpw = scanner.nextLine();
		
		System.out.print("새 이메일 입력 : ");
		String newemail = scanner.nextLine();
		
		boolean result = memberDAO.updateMemberInfo(id, newpw, newemail);
		if(result) {
			System.out.println("회원 정보가 성공적으로 수정되었습니다.");
			System.out.println("=======================");
		}else {
			System.out.println("회원 정보 수정 실패.");
		}
		
	}//멤버 수정 메서드 종료


	private MemberDTO loginMember(MemberDAO memberDAO, MemberDTO session) throws SQLException {
		// dao에게 로그인하는 서비스를 제공한다.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=====================");
		System.out.println("==로그인 서비스를 시작합니다.==");
		System.out.print("아이디 : ");
		String id = scanner.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = scanner.nextLine();
		
		MemberDTO memberDTO = memberDAO.loginMember(id, pw, session);
		
		if(memberDTO != null) {
			System.out.println("로그인 성공! " + memberDTO.getId() + "님 환영합니다.");
			
		
			
		}else {
			System.out.println("로그인 실패 : id 또는 pw가 일치하지 않습니다.");
		}
		System.out.println("===================");
		
		return memberDTO;
	}//멤버 로그인 메서드 종료


	private void createMember(MemberDAO memberDAO) throws SQLException {
		// dao에게 회원가입하는 서비스를 제공한다.
		System.out.println("=======================");
		System.out.println("==회원가입을 진행하겠습니다.==");
		memberDAO.createMember(); // memberDAo에 createMember 메서드 생성해서 연결
		System.out.println("=======================");
		
	}// 회원가입 메서드 종료
	
	
	
	
}//class 종료
