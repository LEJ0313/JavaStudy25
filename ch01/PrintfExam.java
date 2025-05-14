package ch01;

import java.util.Scanner;

public class PrintfExam {

	public static void main(String[] args) {
		
		int i = 97 ;
		String s = "Java" ; 
		double f = 3.14f ;
		
		System.out.printf("%d\n", i);
		System.out.printf("%o\n", i);
		System.out.printf("%x\n", i);
		System.out.printf("%c\n", i);
		System.out.printf("%5d\n", i);
		System.out.printf("%05d\n", i);
		System.out.printf("%s\n", s);
		System.out.printf("%5s\n", s);
		System.out.printf("%-5s\n", s);
		System.out.printf("%f\n", f);
		System.out.printf("%e\n", f);
		System.out.printf("%4.1f\n", f);
		System.out.printf("%04.1f\n", f);
		System.out.printf("%-4.1f\n", f);
		
		Scanner input = new Scanner(System.in) ;
		System.out.println("================") ;
		System.out.print("이름 : ") ;
		String name = input.next() ;

		System.out.print("나이 : ") ;
		int age = input.nextInt() ;
		
		System.out.print("평균 : ");
		double avg = input.nextDouble() ;
		
		System.out.printf("현재 당신의 이름은 %s\n 당신의 나이는 %d\n 평균은 5.2f\n입니다. ",name,age,avg);
		
	}

}
