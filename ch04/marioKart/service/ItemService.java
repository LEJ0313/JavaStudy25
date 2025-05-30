package ch04.marioKart.service;

import java.util.Scanner;

import ch04.marioKart.dto.ItemDTO;

public class ItemService {
	
	//아이템사용 클래스 
	//부메뉴용
	//필드
	
	//생성자
	
	//메서드
	//부메뉴용 메서드 -> 필요한 파라미터(입력객체, 아이템배열, 아이템보유 유무)    
	public ItemDTO use(Scanner input, ItemDTO[] itemDTOs, ItemDTO possessionState) {
			
		
		int answer = (int)(Math.random()*4)+1;
		//컴퓨터가 랜덤 숫자 생성(1~4)
		int question = 0;
		//사용자가 입력하는 숫자 보관용
		
		System.out.println("===아이템사용 메뉴에 진입하셨습니다.");
		System.out.println("1~4까지 숫자를 입력하세요.");
		
		if(question == answer) {
			//사람이 쓴 숫자가 같으면
			System.out.println("아이템 사용 성공" + answer);
		}else if(question != answer) {
			//사람이 쓴 숫자가 다르면
			System.out.println("아이템 사용 실패" + answer);
			//실패시 순위 하락 (ppt 105 응용)
		}
		
	
		return possessionState;
		
	}
					 					
	
}
