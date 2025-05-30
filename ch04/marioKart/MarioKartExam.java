package ch04.marioKart;

import java.util.Scanner;

import ch04.marioKart.dto.CartDTO;
import ch04.marioKart.dto.CharacterDTO;
import ch04.marioKart.dto.GliderDTO;
import ch04.marioKart.dto.ItemDTO;
import ch04.marioKart.dto.MemberDTO;
import ch04.marioKart.dto.TireDTO;
import ch04.marioKart.service.ItemService;
import ch04.marioKart.service.MemberSerivce;

public class MarioKartExam {
	// 필드 -> main()메서드가 있는 필드는 static용으로 만듬
	public static Scanner input = new Scanner(System.in);
	public static MemberDTO[] memberDTOs = new MemberDTO[10];
	// 10명 회원
	public static CharacterDTO[] characterDTOs = new CharacterDTO[15];
	// 케릭터 15개
	public static CartDTO[] cartDTOs = new CartDTO[8];
	// 카트 자동차 8개 배열
	public static GliderDTO[] gliderDTOs = new GliderDTO[10];
	// 글라이더 배열
	public static TireDTO[] tireDTOs = new TireDTO[10];
	// 타이어 배열
	public static ItemDTO[] itemDTOs = new ItemDTO[10];
	// 아이템 배열

	public static MemberDTO loginState; // 세션과 같은 기능
	// 로그인 성공시 객체를 가지고 있는 용도

	// 생성자 -> new MarioKartExam()로 객체를 생성하지 않는다.
	// static{ } 스태틱 블럭을 사용한다. 초기화용
	static {
		CharacterDTO characterDTO0 = new CharacterDTO("마리오", 3.0, 4.5, 3.7, 4.1, 3.8);
		CharacterDTO characterDTO1 = new CharacterDTO("루이지", 3.2, 4.4, 3.1, 4.4, 3.2);
		CharacterDTO characterDTO2 = new CharacterDTO("와리오", 3.4, 4.2, 3.2, 4.2, 3.4);
		CharacterDTO characterDTO3 = new CharacterDTO("피치", 3.1, 4.8, 3.4, 4.5, 3.5);
		// 객체 생성완료

		// 객체를 배열에 넣어서 관리
		characterDTOs[0] = characterDTO0;
		characterDTOs[1] = characterDTO1;
		characterDTOs[2] = characterDTO2;
		characterDTOs[3] = characterDTO3;

	} // 스태틱 블록 종료(main메서드 실행시 초기화 값)

	// 정적 메서드
	public static void main(String[] args) {
		// MVC 패턴을 이용해서 마리오카트 프로그램 제작
		// DTO : 객체용 (Data Transfer Object)
		// service : 부메뉴용 crud
		// main() : 컨트롤러용 (주메뉴, 분기담당)

		System.out.println("========마리오 카트 게임을 시작합니다.===========");
		boolean run = true; // 처음 구동
		while (run) {
			System.out.println("1. 회원관리 | 2. 카트관리 | 3. 게임실행 | 4. 종료");
			System.out.print(">>>");
			int select = input.nextInt(); // 숫자가 아닌경우 오류 발생함.(차후처리)

			switch (select) {
			case 1:
				System.out.println("회원관리 클래스로 진입합니다.");
				MemberSerivce memberSerivce = new MemberSerivce();
				loginState = memberSerivce.menu(input, memberDTOs, loginState);
				System.out.println("현재 로그인한 회원은 : " + loginState.nickName);
				break;

			case 2:
				System.out.println("카트관리 클래스로 진입합니다.");
				break;

			case 3:
				System.out.println("게임실행 클래스로 진입합니다.");
				
				boolean subrun = true;
				while(subrun){
					System.out.println("===게임이 실행되었습니다.===");
					System.out.println("1. 아이템 사용");
					System.out.print(">>>");
					int subselect = input.nextInt();
					
					switch(subselect) {
					case 1 :
						System.out.println("아이템 사용 클래스로 진입합니다.");
						//Item명 + 를 사용합니다.
						//랜덤확률로 사용성공 or 실패
						//성공 -> 순위업 / 실패 -> 순위다운
						//ItemService itemService = new ItemService();
						
						
					}//게임실행 switch문 종료
					
				}//게임실행 while문 종료
				
				break;

			case 4:
				System.out.println("게임종료를 진행합니다.");
				run = false; // while문 종료됨
				break;

			default:
				System.out.println("1~4번 숫자만 입력 하세요");
				// break;
			} // switch문 종료

		} // while문 종료

	} // main() 종료

} // class 종료
