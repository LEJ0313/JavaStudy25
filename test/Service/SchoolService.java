package test.Service;

import java.util.Scanner;

import test.DTO.PersonDTO;

public class SchoolService {
	//필드

	//생성자

	//메서드	

	
	
	
	public void menu(Scanner inputStr, Scanner inputInt,  PersonDTO[] person) {	
		
	boolean run = true;
	while(run) {
		System.out.println("===엠비씨성적관리프로그램===");
		System.out.println("1. 성적 등록");
		System.out.println("2. 성적 보기");
		System.out.println("3. 성적 수정");
		System.out.println("4. 성적 삭제");
		System.out.println("5. 종료");
		System.out.print(">>>");
		String select = inputStr.next();
		switch(select) {
		case "1" : 
			System.out.println("성적 등록메뉴로 입장합니다.");			
			createRegistration(inputStr, inputInt, person);
			break ;
			
		case "2" :
			System.out.println("성적 보기메뉴로 입장합니다.");
			scoreReadAll(inputStr, inputInt, person);
			break;
			
		case "3" :
			System.out.println("성적 수정메뉴로 입장합니다.");
			scoreUpdate(inputStr, inputInt, person);
			
			break;
			
		case "4" :
			System.out.println("성적 삭제메뉴로 입장합니다.");
			break;
			
		case "5" :
			System.out.println("프로그램을 종료합니다.");
			run = false;
			break;
			default : 
				System.out.println("1~5까지만 입력해주세요.");
				break ;
		
		}//switch문 종료
		
	}//while문 종료	
	}

	private void scoreReadAll(Scanner inputStr, Scanner inputInt, PersonDTO[] person) {
		for(int i=0; i<person.length;i++) {
			PersonDTO scorereadall = person[i];
			if(scorereadall != null) {
				System.out.println(scorereadall.getName());
				System.out.println("\t");
			}
		}
		
	}

	private void scoreUpdate(Scanner inputStr, Scanner inputInt, PersonDTO[] person) {
		
		System.out.println("수정할 학생의 이름을 입력하세요");
		System.out.print(">>>");
		String name = inputStr.next();
//		for(int i=0; i<names.length; i++) {
			
	//		if(names[i].equals(name)) {
			//	System.out.println(names[i]+"학생 점수");
				
		//		System.out.println("국어 : " + kors[i]);
		//		System.out.println("영어 : " + engs[i]);
		//		System.out.println("수학 : " + mats[i]);
				System.out.println("==================");
				System.out.println("수정할 점수를 입력하세요");
				System.out.println("국어 수정 점수 : ");
		//		kors[i] = inputInt.nextInt();
				
				System.out.println("영어 수정 점수 : ");
		//		engs[i] = inputInt.nextInt();
				
				System.out.println("수학 수정 점수 : ");
		//		mats[i] = inputInt.nextInt();
				System.out.println("----수정 완료----");
				
		// 		System.out.println("국어 : " + kors[i]);
		//		System.out.println("영어 : " + engs[i]);
		//		System.out.println("수학 : " + mats[i]);
				System.out.println("===================");
	//			break ;
			}//if문 종료
//		}//for문 종료
		
//	}
	
	private void createRegistration(Scanner inputStr, Scanner inputInt, PersonDTO[] person) {
								
		System.out.println("학생수를 입력해주세요");
		System.out.print(">>>");
		
		int count = inputInt.nextInt();
		String[] names = new String[count]; //이름 배열 생성
		int kors[] = new int[count]; //국어 점수 배열 생성
		int engs[] = new int[count]; //영어 점수 배열 생성
		int mats[] = new int[count]; //수학 점수 배열 생성
		char tiers[] = new char[count]; //등급 배열 생성
		double avgs[] = new double[count]; //평균 배열 생성
		
		System.out.println(names.length + "명의 학생 성적을 입력하겠습니다.");
		boolean subrun = true;
		while(subrun) {
			System.out.println("===성적 등록===");
			for(int i=0; i<names.length; i++) {
				System.out.println("학생 이름을 입력하세요");
				System.out.print(">>>");
				names[i] = inputStr.next();
				
				System.out.print("국어 점수 : ");
				kors[i] = inputInt.nextInt();
				
				System.out.print("영어 점수 : ");
				engs[i] = inputInt.nextInt();
				
				System.out.print("수학 점수 : ");
				mats[i] = inputInt.nextInt();
							
				
			}
			System.out.println("성적 입력이 완료되었습니다.");
			break ;	
		}//성적등록 와일문 종료
		
	}
	
}
