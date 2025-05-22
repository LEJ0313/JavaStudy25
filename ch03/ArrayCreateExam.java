package ch03;

public class ArrayCreateExam {

	public static void main(String[] args) {
		//배열 이용하여 총점과 평균 구하기
		int[] scores = null; //null = 값이 없음
		scores = new int[] {83, 90, 87}; //값이 없는 scores에 new타입을 만들어 숫자 대입			
		
		System.out.println("scores[0] : " + scores[0]);
		System.out.println("scores[1] : " + scores[1]);
		System.out.println("scores[2] : " + scores[2]);
		
		int sum = 0 ;
		for(int i = 0 ; i < 3 ; i++) {
			sum += scores[i];
			
			//System.out.println(sum); 총점을 구하는 방법
		}
		System.out.println("총점 : " + sum);
		double avg = (double) sum /3 ; //강제타입변환
		System.out.println("평균 : " + avg);				
	}//main 메서드 종료

}//class 종료
