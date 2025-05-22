package ch04;

import java.util.Scanner;

public class EnumExam {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		//키보드로 입력받을수 있게해주는 스캐너생성
		
		String[] names = null; //String배열로 names변수 생성 값은 나중에 넣음
		String[] ids = null; //String배열로 ids변수 생성 값은 나중에 넣음
		String[] pws = null; //String배열로 pws변수 생성 값은 나중에 넣음
		MemberGrade[] grades = null; //MemberGrade배열로 grades변수 생성 값은 나중에 넣음
		
		System.out.println("몇명의 회원을 가입시키겠습니까?");
		System.out.print(">>>");
		int count = input.nextInt();
		names = new String[count];
		ids = new String[count];
		pws = new String[count];
		grades = new MemberGrade[count]; 
		
		System.out.println("회원가입을 시작합니다.");
		for(int i=0; i < names.length; i++) {
			System.out.print("이름 >>>");
			names[i] = input.next();
			System.out.print("id >>>");
			ids[i] = input.next();
			System.out.print("pw >>>");
			pws[i] = input.next();
			
			System.out.println("-----------등급을 선택하세요----------");
			System.out.println("1. GUEST");
			System.out.println("2. USER");
			System.out.println("3. MANAGER");
			System.out.println("4. ADMIN");
			System.out.print(">>>");
			System.out.println("---------------------------------");
			String grade = input.next();
			
			switch(grade) {
			case "1" :
				grades[i] = MemberGrade.USER;
				System.out.println("손님 등급입니다.");
				break ;
				
			case "2" :
				grades[i] = MemberGrade.USER;
				System.out.println("유저 등급입니다.");
				break ;
				
			case "3" :
				grades[i] = MemberGrade.MANAGER;
				System.out.println("관리자 등급입니다.");
				break ;
				
			case "4" :
				grades[i] = MemberGrade.ADMIN;
				System.out.println("최고관리자 등급입니다.");
				break ;
				
				
				default : 
					System.out.println("잘못 입력하셨습니다.");
									
			}//switch문 종료
			
		}//for문 종료
				
		System.out.println("=========================");
		System.out.println("현재가입내용입니다.");
		for(int i=0; i<names.length; i++) {
			System.out.print("이름 : " + names[i]);
			System.out.print(" | id : " + ids[i]);
			System.out.print(" | pw : " + pws[i]);
			System.out.print(" | 등급 : " + grades[i]);
			
		}								
		

	}//main 메서드 종료

}//class 종료
