package ch02;

import java.util.Scanner;

public class SwitchIfExam {

	public static void main(String[] args) {
		//이름 입력 -> 로또 당첨번호 확인
		//맞춘 갯수별로 금액 안내
		
		Scanner inChar = new Scanner(System.in) ;
		
		System.out.println("로또 당첨 프로그램에 오신걸 환영합니다.");
		System.out.print("이름 : ");
		 
		String gradeStr = inChar.next();

		Scanner in = new Scanner(System.in) ;
		System.out.println("안녕하세요." + gradeStr + "님");
		System.out.println("로또 1부터 45까지 번호중 6개를 입력해주세요.");
		
		int myNum1 = in.nextInt();
		System.out.println("첫번째 번호 : " + myNum1);
		
		int myNum2 = in.nextInt();
		System.out.println("두번째 번호 : " + myNum2);
		
		int myNum3 = in.nextInt();
		System.out.println("세번째 번호 : " + myNum3);
		
		int myNum4= in.nextInt();
		System.out.println("네번째 번호 : " + myNum4);
		
		int myNum5 = in.nextInt();
		System.out.println("다섯번째 번호 : " + myNum5);
		
		int myNum6 = in.nextInt();
		System.out.println("여섯번째 번호 : " + myNum6);
		
	}//main 메서드 종료

}//class 종료
