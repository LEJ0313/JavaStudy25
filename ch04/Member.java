package ch04;

import java.util.Scanner;

public class Member {
		// 회원용 객체로 main() 메서드는 exam에서 진행함
	
		// 클래스의 기본속성은 3가지가 필요함.
		// 기본속성 : 필드, 생성자, 메서드
		
		// 필드(물리적인것들) : 객체가 가지고 있어야 할 값(변수)
		// 회원번호, id, pw, 전화번호, 집주소 등
			
	
	public int mno; // 정수 멤버번호
	public String id; // 문자 id
	public String pw; // 문자 pw

	
		// 생성자 : Exam클래스에서 main클래스에서 new로 호출할 때
	public Member() {
		// 기본생성자 : class명과 같은 메서드
		// Member member = new Member();
	}
	
	
		// 메서드 : Member클래스에서 행해지는 동작(CRUD) 
	public Member memberAdd(Scanner input) {
		// main에서 전달된 스캐너 객체
		// retrun이 있기때문에 void가 변수로 대체
		
		Member member = new Member(); 
		//main에서 가져온 정보를 다시 보내기위한 리턴용 객체
		
		System.out.println("회원가입용 메서드입니다.");
		System.out.println("회원번호를 입력하세요.");
		System.out.print(">>>");
		member.mno = input.nextInt(); //main으로 리턴해야하기 때문에 member.을 붙임
		
		System.out.println("id를 입력하세요.");
		System.out.print(">>>");
		member.id = input.next();
				
		System.out.println("pw를 입력하세요.");
		System.out.print(">>>");
		member.pw = input.next();
		
		return member ;
		
	}//memberAdd() 종료
	
	
	public void memberAllList(Member[] members) {
		System.out.println("모든 회원 보기 리스트 메서드 입니다.");
		for(int i = 0; i < members.length; i++) {
			
			System.out.print("회원번호 : " + members[i].mno);
			System.out.print(" | id : " + members[i].id);
			System.out.print(" | pw : " + members[i].pw);
			
			
		}
		
	}//memberAllList 종료
	
	public void memberLogin(Scanner input) {
		Member member = new Member();
				
		System.out.println("로그인 메서드입니다.");
		System.out.println("회원번호를 입력하세요.");
		System.out.print(">>>");
		member.mno = input.nextInt();
		
		System.out.println("id를 입력하세요.");
		System.out.print(">>>");
		member.id = input.next();
				
		System.out.println("pw를 입력하세요.");
		System.out.print(">>>");
		member.pw = input.next();
		System.out.println("로그인 완료되었습니다.");
		
		boolean run = true;
		while(run) {
			System.out.println("1.메뉴이름");
			System.out.println("1만 입력해주세요. 다른키가 눌리면 로그아웃합니다.");
			System.out.print(">>>");
			
			
			int select = input.nextInt();
			switch(select) {
			case 1 :
				System.out.println("메뉴이름입니다.");
				break ;
				
				default : 
					System.out.println("로그아웃 되었습니다.");
					run = false ;
				
			}//로그인 switch문 종료
							
		}//로그인 while문 종료
		
	}//memberLogin 종료
	
	public void memberUpdate(Member[] members) {		
		
		System.out.println("회원수정 메서드입니다.");
		System.out.println("수정할 회원번호를 입력하세요. >>");	
		
		for(int i = 0; i < members.length; i++) {
			
		System.out.println(members[i].id + "님 메뉴를 선택해주세요.");
		System.out.println("1. id 수정");
		System.out.println("2. pw 수정");
		System.out.println("3. 전체메뉴로 돌아가기");
		System.out.print("(1~3)>>>");
		
		}//회원수정 for문 종료
		
		
		
	}//memberUpdate 종료
	
	public void memberDelete() {
		System.out.println("회원탈퇴 메서드입니다.");
	}//memberDelete 종료
	
	
	

}
