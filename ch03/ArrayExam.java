package ch03;

import java.util.Scanner;

public class ArrayExam {

	public static void main(String[] args) {
		
		Scanner inputInt = new Scanner(System.in); //정수로 입력받을수있게 해주는 스캐너 객체 생성
		
		System.out.println("=====엠비씨 성적처리=====");
		System.out.println("학생수를 입력해주세요.");
		System.out.print(">>>");
		int count = inputInt.nextInt(); //정수 입력 시 count 변수에 입력한 정수가 들어감
		
		String[] names = new String[count]; //이름 배열 생성 (여러개이기 때문에 s붙힘, 문자열이기 때문에 String 사용)
		int[] kors = new int[count]; //국어점수 배열 생성 (정수이기 때문에 int 사용)
		int[] mats = new int[count]; //수학점수 배열 생성
		int[] engs = new int[count]; //영어점수 배열 생성
		char[] tiers = new char[count]; //등급 배열 생성
		double[] avgs = new double[count]; //평균 배열 생성
		
		//국어, 영어, 수학 점수의 배열을 입력한 학생 수(count)만큼 생성
		System.out.println(names.length + "명의 학생 성적을 입력하겠습니다.");
		boolean run = true ;
		
		while(run) {
			System.out.println("====== 성적처리 ======");
			System.out.println("1. 성적입력");
			System.out.println("2. 전체성적보기");
			System.out.println("3. 개인성적보기");
			System.out.println("4. 성적수정하기");
			System.out.println("5. 성적삭제하기");
			System.out.println("9. 성적프로그램 종료");
			System.out.print(">>>");
			int select = inputInt.nextInt(); //정수 입력시 select에 변수에 입력한 정수가 들어감
			
			switch(select) {
			
			case 1 :
				System.out.println("성적입력 화면입니다.");
				//메서드 생성시 입력값과 출력값을 생각해야함
				//입력값 : name - 출력값 : kors, mats, engs 점수
				//이름을 입력하면 점수를 입력할 수 있음
				scoreAdd(names, kors, mats, engs);
				break ;
				
			case 2 :
				System.out.println("전체성적보기 화면입니다.");
				//누구의 성적을, 어떤것을 볼건지 생각
				//입력값 : name? - 출력값 : name, kor, mat, eng 점수 (등급, 평균, 등수)
				//이름을 입력하면 이름, 점수(등급,평균,등수)를 볼 수 있음
				scoreRead(names, kors, mats, engs, tiers, avgs);
				break ;
				
			case 3 :
				System.out.println("개인성적보기 화면입니다.");
				break ;
				
			case 4 :
				System.out.println("성적수정하기 화면입니다.");
				scoreMod(names, kors, mats, engs); //main메서드에 만든 변수들을 main메서드 바깥쪽으로 보내서 기능구현
				break ;
				
			case 5 :
				System.out.println("성적삭제하기 화면입니다.");
				break ;
				
			case 9 :
				System.out.println("성적처리 종료! 프로그램이 종료됩니다...");
				run = false ;
				break ;
				
			}//성적처리 메뉴 switch문 종료
									
		}//성적처리 while문 종료				
		
	}// main 메서드 종료

	static void scoreRead(String[] names, int[] kors, int[] mats, int[] engs, char[] tiers,
			double[] avgs) {
		
		
		
	}//전체성적보기 메뉴 종료

	static void scoreAdd(String[] names, int[] kors, int[] mats, int[] engs) {
		Scanner inputStr = new Scanner(System.in); //키보드로 문자열을 입력받을수 있게 해주는 스캐너 생성
		Scanner inputInt = new Scanner(System.in); //키보드로 정수를 입력받을수 있게 해주는 스캐너 생성
		
		for(int i = 0 ; i < names.length ; i++) {
			System.out.println("이름을 입력하세요"); //성적을 입력할 이름 등록
			System.out.print(">>>");
			names[i] = inputStr.nextLine();
			
			System.out.print("국어점수 : ");
			kors[i] = inputInt.nextInt();
			
			System.out.print("수학점수 : ");
			mats[i] = inputInt.nextInt();
			
			System.out.print("영어점수 : ");
			engs[i] = inputInt.nextInt();
			}// 반복 성적 입력 종료
			System.out.println("성적 입력이 완료되었습니다.");
		
		
	}//성적 입력 메서드 종료

	static void scoreMod(String[] names, int[] kors, int[] mats, int[] engs) {
		//main에서 만든 배열 4개를 가져와 성적 수정을 한다.
		Scanner inputStr = new Scanner(System.in); //키보드로 문자열을 입력받을수 있게 해주는 스캐너 생성
		Scanner inputInt = new Scanner(System.in); //키보드로 정수를 입력받을수 있게 해주는 스캐너 생성
		
		System.out.println("수정할 학생의 이름을 입력하세요.");
		System.out.print(">>>");
		String name = inputStr.next(); //문자열로 입력시 name 변수에 입력한 문자열이 들어감
		for(int i = 0 ; i < names.length ; i ++) { //length : 배열의 방 갯수
			
			if(names[i].equals(name)) {
				//키보드로 입력한 값이 이름배열에 같은값이 있는지 파악
				System.out.println(names[i]+"학생 점수");
				//names = 내가 입력한 학생의 이름
				
				System.out.println("국어 : " + kors[i]); //입력한 국어 점수가 kors[i]에 출력됨
				System.out.println("수학 : " + mats[i]); //입력한 수학 점수가 mats[i]에 출력됨
				System.out.println("영어 : " + engs[i]); //입력한 영어 점수가 engs[i]에 출력됨
				System.out.println("=================");
				System.out.println("수정할 점수를 입력하세요");
				System.out.print("국어 수정 점수 : ");
				kors[i] = inputInt.nextInt(); //키보드로 정수를 입력해서 kors의 값을 수정함
				
				System.out.print("수학 수정 점수 : ");
				mats[i] = inputInt.nextInt();
				
				System.out.print("영어 수정 점수 : ");
				engs[i] = inputInt.nextInt();
				System.out.println("수정완료!!");
				
				System.out.println("국어 : " + kors[i]);
				System.out.println("수학 : " + mats[i]);
				System.out.println("영어 : " + engs[i]);
				System.out.println("==================");
				//수정한 점수들을 최종적으로 확인할 수 있음
				break ;				
			}			
			
		}//성적 수정 for문 종료		
		
	}//성적 수정 메서드 종료

	
	
}//class 종료
