package ch02;

public class BreakOutterExam {

	public static void main(String[] args) {
	
		Outter : for(char upper = 'A' ; upper <='Z' ; upper ++) {
			for(char lower = 'a' ; lower <= 'z' ; lower ++) {
				System.out.println(upper + " - " + lower);
				if(lower=='v') { //c가 나오면 break문 실행
					break Outter ; //Outter은 라벨문으로 break의 범위를 설정
				}
			}
		}
		

	}//main 메서드 종료

}//class 종료
