package ch04;

import java.util.Scanner;

public class Member1 { //회원에 대한 CRUD
	
	//필드 -> 멤버변수
	
	String id;
	String pw;
	String nickname;
	String email;
	
	//생성자 -> new로 객체 생성시 사용(생략시 기본생성자가 자동으로 만들어 짐)
	
	//Member member = new Member();
	
	
	
	//메서드 -> 동작(CRUD)
	
	public Member1 register(Scanner input) {
		//새로운 멤버객체를 생성하여 키보드로 넣은 필드값을 삽입하고 객체로 리턴
		
		Member1 newMember = new Member1();
		System.out.println("아이디를 입력하세요.");
		newMember.id = input.next();
		
		System.out.println("암호를 입력하세요.");
		newMember.pw = input.next();
		
		System.out.println("닉네임을 입력하세요.");
		newMember.nickname = input.next();
		
		System.out.println("이메일을 입력하세요.");
		newMember.email = input.next();
		
		return newMember;
				
	}
	
	public Member1 login(Scanner input, Member1[] members) {
		//		매개값		키보드입력			회원배열
		
		System.out.println("로그인을 시작합니다.");
		Member1 loginMember = new Member1();//키보드로 입력한 객체 생성
		
		System.out.println("아이디를 입력하세요.");
		System.out.print(">>>");
		loginMember.id = input.next();
		//키보드로 입력받은 id를 새로만든 객체에 넣음
		
		System.out.println("암호를 입력하세요.");
		System.out.print(">>>");
		loginMember.pw = input.next();
		//키보드로 입력받은 pw를 새로만든 객체에 넣음
		
		//배열에 있는 객체와 새로만든 객체 비교 시작
		
		for(int i = 0; i < members.length; i++) {
			if(members[i] != null) {//배열에 빈칸이 아니면
				if(members[i].id.equals(loginMember.id) && members[i].pw.equals(loginMember.pw)) {
					//배열에 있는 id와 키보드로 입력한 id가 같고 배열에 있는 pw와 입력한 pw가 같다
					//loginMember는 2개의 값 member[i] 4개의 값을 가지고 있다.
					
					loginMember = members[i];//교체
				}//if문 종료 (id, pw 비교, 객체 치환)
				
			}else {
				System.out.println("회원 정보가 없습니다.");
				System.out.println("id / pw를 확인하세요.");
				break ;
			}//if문 종료
			
		}//for문 종료
		
		return loginMember;
		
	}
	
	public void modify() {
		System.out.println("회원정보 수정을 시작합니다.");
	}
	
	public void delete() {
		System.out.println("회원 탈퇴를 시작합니다.");
	}
	
	public void menu(Scanner input, Member1[] members) {
		//매개값          스캐너           멤버배열
		System.out.println("---회원 전용 메뉴입니다.---");
		
		boolean run = true;
		
		while(run) {
			System.out.println("1. 가입 | 2. 로그인 | 3. 수정 | 4. 탈퇴 | 5. 종료");
			System.out.print(">>>");
			
			int select = input.nextInt();
			switch(select) {
			case 1 :
				System.out.println("회원가입을 진행합니다.");
				//키보드로 입력받을 필드 완성 후 객체로 받음
				
				Member1 newMember = register(input);
				
				//멤버배열 null을 찾아 삽입
				
				for(int i = 0; i < members.length; i++) {
					if(members[i] == null) {
						members[i] = newMember;
						
						System.out.println(newMember.nickname + "객체가 배열에 저장됨");
						break ; //for문이 끝나야함
						
					}//if문 종료
					
				}//for문 종료 (null을 찾아 객체에 삽입)
				break ;
				
			case 2 :
				System.out.println("로그인을 진행합니다.");
				
				Member1 loginMember = login(input, members);
				//호출시 스케너와 배열 객체 전달
				
				System.out.println(loginMember.nickname + "님 환영합니다.");
				break ;
				
			case 3 :
				System.out.println("회원수정을 진행합니다.");
				
				modify();
				break ;
				
			case 4 :
				System.out.println("탈퇴를 진행합니다.");
				
				delete();
				break ;
				
			case 5 : 
				System.out.println("회원전용 메뉴를 종료합니다.");
				
				run = false ;
				break ;
				
				default : 
					System.out.println("1~5사이의 값만 입력하세요.");
				
			
			}//switch문 종료
			
		}//while문 종료
		
	}
	

}
