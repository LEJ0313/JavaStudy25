package ch04;

import java.util.Scanner;

public class MemberObjExam {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //키보드로 입력받을수 있는 스캐너 객체 생성
		
		Member[] members = null; //Member배열 members변수에 값이 없음(값을 나중에 넣을수 있음)
		
		System.out.println("가입할 회원수를 입력하세요.");
		System.out.print(">>>");
		int count = input.nextInt(); //count변수에 키보드로 입력한 숫자를 대입
		members = new Member[count]; //키보드로 입력한 숫자만큼 배열 생성
		
		System.out.println("회원가입을 시작합니다.");
		boolean run = true; //while(반복문)을 사용하기위한
		while(run) {
			
			System.out.println("==========================");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원전체보기");
			System.out.println("3. 회원로그인");
			System.out.println("4. 회원수정");
			System.out.println("5. 회원탈퇴");
			System.out.println("1~5까지만 눌러주세요. 다른키가 눌리면 종료됩니다.");
			System.out.print(">>>");
			
			
			
			int select = input.nextInt(); //switch문을 사용하기위한
			switch(select) {
			case 1 : 
				Member member1 = new Member(); //메서드를 호출할 객체 생성
				for(int i = 0; i < members.length; i++) {
				
				member1 = member1.memberAdd(input); //메서드 호출 및 실행
				members[i] = member1 ;
				}
				break ;
				
			case 2 :
				Member member2 = new Member(); //메서드 호출할 객체 생성
				member2.memberAllList(members); //메서드 호출 및 실행
				break ;
				
			case 3 :
				Member member3 = new Member(); //메서드 호출할 객체 생성
				member3.memberLogin(input); //메서드 호출 및 실행
				break ;
				
			case 4 :
				Member member4 = new Member(); //메서드 호출할 객체 생성
				member4.memberUpdate(members); //메서드 호출 및 실행
				
				break ;
				
				
			case 5 :
				Member member5 = new Member(); //메서드 호출할 객체 생성
				member5.memberDelete(); //메서드 호출 및 실행
				break ;
				
				default : 
					System.out.println("회원가입 프로그램 종료");
					run = false;
			
			}//switch문 종료
			
		}//while문 종료
									

	}//main메서드 종료

}//class 종료
