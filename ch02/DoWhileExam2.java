package ch02;

import java.util.Scanner;

public class DoWhileExam2 {

	public static void main(String[] args) {
		//업앤다운 게임 만들기
		//컴퓨터가 랜덤한 숫자를 생성(1~50)
		//사용자가 숫자를 입력한다.
		//컴퓨터가 랜덤숫자를 판단하여 up / down 을 알려준다.
		//사용자의 숫자와 컴퓨터의 숫자가 일치하면 프로그램 종료와 함께 당첨 사실을 알린다.
		//3번 안에 성공시 상품 증정용 코드 추가
		
		int answer = (int)(Math.random()*50) + 1 ;
		//컴퓨터가 랜덤한 숫자를 제공함 (1~50까지)
		
		Scanner input = new Scanner(System.in) ;
		//키보드로 입력받는 객체 생성
		
		int question = 0 ;
		//사용자가 입력하는 숫자 보관용
		
		int hits = 0 ; 
		//카운트용
		
		System.out.println("==========================");
		System.out.println("업&다운 게임에 오신걸 환영합니다.");
		System.out.println("5번 안에 맞추면 상품을 제공합니다.");
		System.out.println("상품 제공은 관리자에게 문의하세요.");
		System.out.println("==========================");
		
		do {
			System.out.println("1부터 50사이의 숫자를 입력해주세요.");
			question = input.nextInt() ;
			//사용자가 숫자를 키보드로 입력할 수 있게 해준다.
			
			hits ++ ; //키보드로 입력한 회수 카운트용
			if(question > answer) {
			//사람이 쓴 숫자가 크니 답은 아래쪽에 있다.
				System.out.println("down");
			}else if(question < answer) {
				//사람이 쓴 숫자가 작으니 답은 위쪽에 있다.
				System.out.println("up");
			}
		}while(question != answer) ; //do~while문 종료
		//랜덤 숫자와 사용자의 입력한 숫자가 같지 않으면 do문으로 올라가 실행
		//랜덤 숫자와 사용자의 입력한 숫자가 같으면 아래로 내려옴
		System.out.println("정답입니다. " + answer);
		System.out.println("고객님이 맞춘 횟수 : " + hits + "입니다.");
		if(hits<=5) {
			System.out.println("상품수령 : 관리자가 연락을 드립니다.");
		}else {
			System.out.println("상품수령 실패 : 다음번 기회는 없습니다.");
		}
	}//main 메서드 종료

}//class 종료
