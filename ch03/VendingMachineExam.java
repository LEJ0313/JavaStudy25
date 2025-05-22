package ch03;

import java.util.Scanner;

public class VendingMachineExam {

	public static void main(String[] args) {	
		
		
		
		boolean play = true ;
		boolean add = true ;
		
		  // 관리자 모드 사용 초기값;
	      boolean Manager = true; // while문 실행을 위해 true 값 선언
	      int numMenu = 0; // 치킨 메뉴 가짓수 
	      int numMenu2 = 0; // 사이드 메뉴 가짓수
	      String[] chikenMenu = null; // 치킨 종류 
	      String[] sideMenu = null; // 사이드 종류 
	      int[] price = null; // 치킨 가격 
	      int[] price2 = null; // 사이드 가격 
	      int[] stock = null; // 치킨 재고 
	      int[] stock2 = null; // 사이드 재고 
		
	   // 고객 모드 사용 초기값
	      boolean customer = false;
	      int selectNo = 0;
	      int sideNo = 0;
	      int money = 0;
	      int num = 0;
		
	      Scanner scanner = new Scanner(System.in);
	      
	      while(play) {
	    	  System.out.println("========================");
	    	  System.out.println("주문하실 치킨을 선택해주세요.");
	    	  System.out.println("1. 후라이드 | 2. 양념");
	    	  System.out.print("숫자입력 >>>");
	    	  int type = scanner.nextInt();
	    	  
	    	  System.out.println("영업 준비중입니다.");
	    	  System.out.println("========================");
	    	  
	    	  if(type == 1) {//후라이드 선택
	    		  while(customer) {
	    			  System.out.println("============================");
	    			  System.out.println("현재 주문이 가능한 치킨 메뉴입니다.");
	    			  System.out.println("1번" + chikenMenu[0] + "가격" + price[0] + "원 재고" + 
	    			  stock[0] + "개"); //황금올리브
	    			  System.out.println("2번" + chikenMenu[1] + "가격" + price[1] + "원 재고" + 
	    			  stock[1] + "개"); //Hot후라이드
	    			  System.out.println("3. 이전 메뉴로 돌아가기");
	    			  System.out.print("숫자입력 >>>");
	    			  selectNo = scanner.nextInt();
	    			  
	    			  switch(selectNo) {//사이드 선택하는 switch문
	    			  case 1 : //chikenMenu[0]을 선택
	    				  System.out.println("======================");
	    				  System.out.println("추천 사이드 메뉴입니다.");
	    				  System.out.println("1번" + sideMenu[0] + "가격" + price[0] + "원 재고" + 
	    				  stock[0] + "개"); //치즈볼
	    				  System.out.println("2번" + sideMenu[1] + "가격" + price[1] + "원 재고" + 
	    				  stock[1] + "개"); //콜라
	    				  System.out.println("3번 추가안함");
	    				  System.out.println("4. 이전 메뉴로 돌아가기");
	    				  System.out.print("숫자입력 >>>");
	    				  sideNo = scanner.nextInt();
	    				  
	    				  if (sideNo == 1) {// sideMenu[0]번 선택
	    					  System.out.println("=====================");
	    					  System.out.println("주문을 확인해주세요.");
	    					  System.out.println(chikenMenu[0] + "에" + sideMenu[0] + "추가");
	    					  System.out.println("결제하실 금액은" + (price[0]+price2[0]) + "원 입니다.");
	    					  System.out.println("1. 결제하기 | 2. 돌아가기");
	    					  System.out.print("숫자입력 >>>");
	    					  num = scanner.nextInt();
	    					  
	    					  if (num == 1) {//결제하기 선택
	    						  System.out.println("=======================");
	    						  System.out.println("결제를 진행하겠습니다.");
	    						  System.out.println("결제는 현금만 가능합니다.");
	    						  System.out.println("결제취소는 5번을 입력해주세요.");
	    						  
	    						  while(add) {
	    							  System.out.println("1. 1000원 | 2. 5000원 | 3. 10000원");
	    							  System.out.print("금액을 입금해주세요. >>>");
	    							  int seletMoney = scanner.nextInt();
	    							  
	    							  switch(seletMoney) {
	    							  case 1 :
	    								  money += 1000;
	    								  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    								  break ;
	    								  
	    							  case 2 :
	    								  money += 5000;
	    								  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    								  break ;
	    								  
	    							  case 3 :
	    								  money += 10000;
	    								  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    								  break ;
	    								  
	    							  }//돈 입금 switch문 종료
	    							  
	    							  if(money >= price[0]+price2[0]) {//입금된 금액이 결제할 금액보다 높을 경우 -> 결제 진행
	    								  System.out.println("=======================");
	    								  System.out.println("주문 감사합니다.");
	    								  System.out.println("거스름돈 반환 후 주문이 접수됩니다.");
	    								  System.out.println("거스름돈" + (money -(price[0+price2[0]])) + "을 받으세요.");
	    								  
	    								  customer = false ;
	    								  add = false ;
	    								  play = false ;
	    								  break ;
	    								  
	    							  }else if(money < price[0]+price2[0]) {//입금된 금액이 결제할 금액보다 낮은 경우 -> 입금 진행
	    								  System.out.println("잔액이 부족합니다.");
	    								  System.out.println("추가 입금이 필요합니다.");
	    								  continue;
	    								  
	    							  }//잔액 확인 후 결제하는 if문 종료
	    								  
	    						}//while add문 종료
	    						  
	    					  }else if(num == 2) {//돌아가기를 선택
	    						  break ;
	    						  
	    					  }//돌아가기를 선택문 종료
	    					  
	    				  }else if(sideNo == 2) {//sideMenu[1]을 선택
	    					  System.out.println("============================");
	    					  System.out.println("주문을 확인해주세요.");
	    					  System.out.println(chikenMenu[0] + "에" + sideMenu[1] + "추가");
	    					  System.out.println("결제하실 금액은" + price[0]+price2[1] + "원 입니다.");
	    					  System.out.println("1. 결제하기 | 돌아가기");
	    					  System.out.print("숫자입력 >>>");
	    					  num = scanner.nextInt();
	    					  
	    					  if(num == 1) {//결제하기를 선택
	    						  System.out.println("======================");
	    						  System.out.println("결제를 진행하겠습니다.");
	    						  System.out.println("결제는 현금만 가능합니다.");
	    						  System.out.println("결제취소는 5번을 입력해주세요.");
	    						  
	    						  while(add) {
	    							  System.out.println("1. 1000원 | 2. 5000원 | 3. 10000원");
	    							  System.out.println("금액을 입금해주세요. >>>");
	    							  int selectMoney = scanner.nextInt();
	    							  
	    							  switch(selectMoney) {
	    							  case 1 :
	    								  money += 1000;
	    								  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    								  break ;
	    								  
	    							  case 2 :
	    								  money += 5000;
	    								  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    								  break ;
	    								  
	    							  case 3 :
	    								  money += 10000;
	    								  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    							  
	    							  }//돈 입금 switch문 종료
	    							  
	    							  if(money >= price[0]+price2[1]) {//입금한 돈이 결제할 금액보다 높은 경우 -> 결제 진행
	    								  System.out.println("==================");
	    								  System.out.println("주문 감사합니다.");
	    								  System.out.println("거스름돈 반환 후 주문이 접수됩니다.");
	    								  System.out.println("거스름돈" + (money -(price[0]+price2[1]) + "을 받으세요."));
	    								 customer = false; 
	    								 add = false;
	    								 play = false;
	    								 break ;
	    								  
	    							  }else if (money < price[0]+price2[1]) {//입금한 돈이 결제할 금액보다 낮은 경우 -> 입금 진행
	    								  System.out.println("잔액이 부족합니다.");
	    								  System.out.println("추가입금이 필요합니다.");
	    								  continue;
	    								  
	    							  }//잔액 확인 후 결제하는 if문 종료
	    							  
	    						  }//while add문 종료
	    						  			  
	    					  }else if(num ==2) {//돌아가기를 선택
	    						  break ;
	    					  }//돌아가기를 선택 if문 종료
	    					  
	    				  }
	    					  
	    				  
	   				  break ;
	    				  
	    			  case 2 : //chikenMenu[1]을 선택
	    				  System.out.println("======================");
	    				  System.out.println("추천 사이드 메뉴입니다.");
	    				  System.out.println("1번" + sideMenu[0] + "가격" + price[0] + "원 재고" + 
	    				  stock[0] + "개"); //치즈볼
	    				  System.out.println("2번" + sideMenu[1] + "가격" + price[1] + "원 재고" + 
	    				  stock[1] + "개"); //콜라
	    				  System.out.println("3번 추가안함");
	    				  System.out.println("4. 이전 메뉴로 돌아가기");
	    				  System.out.print("숫자입력 >>>");
	    				  sideNo = scanner.nextInt(); 
	    				  
	    				  if (num == 1) {//결제하기를 선택
	    					  System.out.println("==========================");
	    					  System.out.println("결제를 진행하겠습니다.");
	    					  System.out.println("결제는 현금만 가능합니다.");
	    					  System.out.println("결제 취소는 5번을 입력해주세요.");
	    					  
	    					  while(add) {
	    						  System.out.println("1. 1000원 | 2. 5000원 | 3. 10000원");
	    						  System.out.print("금액을 입금해주세요. >>>");
	    						  int selectMoney = scanner.nextInt();
	    						  
	    						  switch(selectMoney) {
	    						  case 1 :
	    							  money += 1000;
	    							  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    							  break ;
	    							  
	    						  case 2 :
	    							  money += 5000;
	    							  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    							  break ;
	    							  
	    						  case 3 :
	    							  money += 10000;
	    							  System.out.println("현재 입금 금액은" + money + "원 입니다.");
	    							  break ;
	    						  
	    						  }//돈 입금 switch문 종료
	    						  
	    						  if(money >= price[1]+price2[0]) {//입금된 금액이 결제할 금액보다 높은 경우 -> 결제 진행
	    							  System.out.println("=========================");
	    							  System.out.println("주문 감사합니다.");
	    							  System.out.println("거스름돈 반환 후 주문이 접수됩니다.");
	    							  System.out.println("거스름돈" + (money -(price[1]+price2[0]) + "을 받으세요."));
	    							  customer = false ;
	    							  add = false ;
	    							  play = false ;
	    							  
	    						  }else if (money < price[1]+price2[1]) {//입금된 금액이 결제할 금액보다 낮은 경우 -> 입금 진행
	    							  System.out.println("잔액이 부족합니다.");
	    							  System.out.println("추가입금이 필요합니다.");
	    							  continue;
	    							  
	    						  }//잔액 확인 후 결제하는 if문 종료
	    						  
	    					  }//while add문 종료
	    					  
	    				  }else if (num == 2) {//돌아가기를 선택
	    					  break ;
	    					  
	    				  }//돌아가기 if문 종료
	    				 
	    			  }//side선택 switch문 종료
	    			  
	    					 
	    			  
	    		  }//고객모드 customer while문 종료
	    		  break ;
	    		  
	    	  }else if (type == 2) {//양념 메뉴 선택
	    		  while (customer) {
	    			  System.out.println("====================");
	    			  System.out.println("현재 주문이 가능한 치킨 목록 입니다.");
	    			  System.out.println("1번 " + chikenMenu[2] + "가격" + price[2] + "원 재고" + 
	    			  stock[2] + "개");
	    			  System.out.println("2번" + chikenMenu[3] + "가격" + price[3] + "원 재고" + 
	    			  stock[3] + "개");
	    			  System.out.println("3. 이전 메뉴로 돌아가기");
	    			  System.out.print("숫자를 입력해주세요 >>>");
	    			  sideNo = scanner.nextInt();
	    			  
	    			  
	    			  switch(selectNo) {//토핑 선택하는 switch문
	    			  case 1 : //chikenMenu[2]를 선택
	    				  System.out.println("====================");
	    				  System.out.println("추천 사이드 메뉴입니다.");
	    				  System.out.println("1번" + sideMenu[0] + "가격 : ");
	    			  
	    			  }
	    			  
	    		  }
	    		  
	    	  }
	    	  
	      }
	      
	} // main메서드 종료

} // class종료
