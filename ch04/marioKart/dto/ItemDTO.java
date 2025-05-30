package ch04.marioKart.dto;

import java.util.Scanner;

public class ItemDTO {
	//방법 1 : 업다운게임코드로(ppt 111) 정답(1~4) 맞출시 hit, 오답일시 빗나감
	//방법 2 : 아이템 입력 (ppt112)-> 랜덤확률로(ppt91) hit -> 맞으면 속도가 줄어듬 or 순위가 내려감
	//int hit = (int)(Math.random()*4)+1; -> 1~4까지 랜덤
	//순위변동 -> 자동차 액셀,브레이크 활용해볼것(ppt 105)
	
	//아이템 : 거북이 등껍질, 바나나껍질 
	//아이템명, 갯수
	
	//필드
	public String itemname; //아이템명
	public int number; //갯수
	
	//기본생성자 -> new ItemDTO();
	//생성자
	public ItemDTO itemDTO; //
	
	
	
	//메서드
	
	
	
	
	
	

}
