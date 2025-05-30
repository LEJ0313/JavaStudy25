package ch04.marioKart.service;

import java.util.Scanner;

import ch04.marioKart.dto.MemberDTO;

public class MemberSerivce {
	// 회원관리용 클래스로 CRUD@까지 제공
	// 부메뉴용
	// 필드

	// 기본 생성자는 자동으로 생성된다.

	// 메서드

	// 부메뉴용 메서드 -> 필요한 파라미터???? (입력객체, 회원배열, 로그인상태)
	public MemberDTO menu(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
	//main이 아니기 때문에 static 제외
	
		System.out.println("==== 회원관리 메뉴에 진입하셨습니다. ====");
		boolean subrun = true;
		while (subrun) {

			System.out.println("1. 가입 | 2. 로그인 | 3. 수정 | 4. 삭제 | 5. 종료");
			System.out.print(">>>");
			String select = input.next();
			switch (select) {
			case "1":
				System.out.println("계정을 생성합니다.");
				create(input, memberDTOs);
				break;
			case "2":
				System.out.println("로그인합니다.");
				loginState = login(input, memberDTOs, loginState);
				break;
			case "3":
				System.out.println("계정을 수정합니다.");
				break;
			case "4":
				System.out.println("계정을 삭제합니다.");
				break;
			case "5":
				System.out.println("회원관리메뉴를 종료합니다.");
				System.out.println("메인메뉴로 복귀합니다.");
				subrun = false;
				break;

			case "99":
				System.out.println("히든 메뉴로 진입하였습니다.");
				System.out.println("캐릭터 해킹을 진행합니다.");
				break;

			default:
				System.out.println("1~5사이 값만 허용합니다.");

			}// 선택문 종료

		} // 와일문 종료

		return loginState; //main에서 받아온 정보를 다시 돌려보냄
	} // 메뉴 메서드 종료

	public void create(Scanner input, MemberDTO[] memberDTOs) {
		// 회원가입용 메서드
		System.out.println("회원가입용 메서드에 오신걸 환영합니다.");
		MemberDTO memberDTO = new MemberDTO(); // 빈 객체 생성

		System.out.println("사용할 id를 입력하세요");
		System.out.print(">>>");
		memberDTO.id = input.next();
		System.out.println("사용할 pw를 입력하세요");
		System.out.print(">>>");
		memberDTO.pw = input.next();
		System.out.println("사용할 닉네임를 입력하세요");
		System.out.print(">>>");
		memberDTO.nickName = input.next();
		System.out.println("사용할 이메일를 입력하세요");
		System.out.print(">>>");
		memberDTO.email = input.next();
		// 빈 MemberDTO 객체에 필드값 입력 완료

		// memberDTOs[10] 배열에 0~ null 값이면 삽입 (exam)
		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] == null) { // null 이면 값이 없음
				memberDTOs[i] = memberDTO;
				break;
			} // if문 종료

		} // for문 종료
		System.out.println(memberDTO.nickName + "님 회원가입을 축하드립니다.");

	}

	public MemberDTO login(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 로그인용 메서드
		System.out.println("id를 입력하세요.");
		System.out.print(">>>");
		String id = input.next();
		System.out.println("pw를 입력하세요.");
		System.out.print(">>>");
		String pw = input.next();
		// 키보드로 입력 완료 -> 빈객체 생성 -> 삽입
		MemberDTO loginMember = new MemberDTO();
		loginMember.id = id;
		loginMember.pw = pw;
		
		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] != null && memberDTOs[i].id.equals(loginMember.id)
					&& memberDTOs[i].pw.equals(loginMember.pw)) {
				System.out.println("로그인 성공");
				loginState = memberDTOs[i]; // 배열에 있는 정보가 login상태 객체에 삽입
			} // if문 종료
		} // for문 종료
		System.out.println(loginState.nickName + "님 로그인 성공!!!");
		return loginState; // 로그인 성공객체를 리턴함
	}

}
