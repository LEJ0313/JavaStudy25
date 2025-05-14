package ch02;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in) ;
		
		System.out.println("귀하의 성함을 입력해주세요.");
		System.out.print(">>>");
		String name = input.nextLine();
		
		System.out.println("국어점수 입력하세요.");
		System.out.print(">>>");
		int kor = input.nextInt();
		if (kor < 0 || kor > 100){
			System.out.println("영어점수 입력하세요.");
			}
		
		System.out.println("수학점수 입력하세요.");
		System.out.print(">>>");
		int eng = input.nextInt();
		if (eng < 0 || eng > 100) {
			System.out.println("�ٽ� �Է����ּ���.");
			}
		
		System.out.println("�������� �Է��ϼ���.");
		System.out.print(">>>");
		int mat = input.nextInt();
		if (mat < 0 || mat > 100) {
			System.out.println("�ٽ� �Է����ּ���.");
			}
		
		int total = kor + mat + eng ;
		double avg = (double)total /3 ;
		System.out.println("Ȯ�εǾ����ϴ�.");
		System.out.print("����� ����Ͻðڽ��ϱ�? : ");
		String answer = input.next() ;
		if (answer.equalsIgnoreCase("yes")) {
			System.out.println("====�����====");
			System.out.println("��� " + avg);
		}else {
			System.out.println("�ٽ� �Է����ּ���.");
		}
		
	}

}
