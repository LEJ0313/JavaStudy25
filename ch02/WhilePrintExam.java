package ch02;

public class WhilePrintExam {

	public static void main(String[] args) {
		
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++ ; //증감식을 꼭 넣어야함. 안넣으면 무한루프에 빠짐
			
		}//while문 종료
		
	}//main 메서드 종료

}//class 종료
