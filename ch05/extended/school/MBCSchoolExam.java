package ch05.extended.school;

import java.util.Scanner;

public class MBCSchoolExam {

	public static void main(String[] args) {
		// 객체를 생성하여 상속테스트용
		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		
		Teacher teacher = new Teacher(); //방법 1 ----
		System.out.println("교직원 번호를 입력하세요 : ");
		teacher.setTeacherID(inputStr.next());
		
		System.out.println("담당 학년을 입력하세요 : ");
		teacher.setGrade(inputInt.nextInt());
		
		System.out.println("담당교실을 입력하세요 : ");
		teacher.setRoom(inputInt.nextInt());
		
		System.out.println("학생수를 입력하세요 : ");
		teacher.setRoom(inputInt.nextInt());
		
		System.out.println("선생님 이름을 입력하세요");
		teacher.setName(inputStr.next());
		
		System.out.println("선생님 키를 입력하세요");
		teacher.setHeight(inputInt.nextInt());
		
		System.out.println("선생님의 몸무게를 입력하세요");
		teacher.setWeight(inputInt.nextInt());
		
		System.out.println("입력된 선생님의 정보입니다. " + teacher);
		System.out.println("=========================");
		// ---------------
		
		System.out.println("학생의 이름을 입력하세요");//방법 2----
		String name = inputStr.next();
		
		System.out.println("학생의 나이를 입력하세요");
		int age = inputInt.nextInt();
		
		System.out.println("학생의 키를 입력하세요");
		int height = inputInt.nextInt();
		
		System.out.println("학생의 몸무게를 입력하세요");
		int weight = inputInt.nextInt();
		
		System.out.println("학생의 학번을 입력하세요");
		String sid = inputStr.next();
		
		System.out.println("학생의 학년을 입력하세요");
		int grade = inputInt.nextInt();
		
		System.out.println("학생의 학점을 입력하세요");
		int gpa = inputInt.nextInt();
		
		Student student = new Student(name, height, age, gpa, sid, grade, gpa);
		//생성자를 통해서 값을 넣음
		
		student.show();//student객체 안에 메서드
		
	}//main메서드 종료

}//class 종료
