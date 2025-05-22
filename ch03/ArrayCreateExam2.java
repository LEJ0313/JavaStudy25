package ch03;

public class ArrayCreateExam2 {

	public static void main(String[] args) {
		//메서드를 활용한 평균 계산
		
		int sum = add(new int[] {70, 80, 90} ) ;
		System.out.println("총합 : " + sum);
		

	}//main 메서드 종료

	static int add(int[] scores) {
		int sum = 0 ;
		for(int i = 0; i<3; i++) {
			sum += scores[1] ;
		}
		
		return sum;
	}

}//class 종료
