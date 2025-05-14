package ch02;

public class BreakExam {

	public static void main(String[] args) {
		
		int i = 0 ;
		while(true) {
			int num = (int)(Math.random() * 45) + 1 ;
			System.out.println("오늘의 로또 번호 : " + num);
			i++ ;
			if (i == 6) {
				System.out.println("프로그램 종료");
				break ;
			}
		}
		
		

	}//main 메서드 종료

}//class 종료
