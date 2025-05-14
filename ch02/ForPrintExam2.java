package ch02;

public class ForPrintExam2 {

	public static void main(String[] args) {
		
		int sum = 0 ; //누적합계를 구하는 변수 선언

		for(int i = 1 ; i <= 100 ; i++) {
			sum = sum + i ;
		}//for문 종료
		
		System.out.println("1~100까지의 합 : " + sum);
		
	}//main 메서드 종료

}//class 종료
