package ch04;

import java.util.Calendar;

import ch02.CalcuratorExam;

public class EnumWeekExam {

	public static void main(String[] args) {
		Week today = null ; //Week타입에 today변수를 선언하고 값은 나중에 넣겠다
		
		Calendar cal = Calendar.getInstance();//캘린더 인스턴스 생성
		int year = cal.get(Calendar.YEAR); //년도를 얻어 온다.
		int month = cal.get(Calendar.MONTH)+1; // 컴퓨터는 0부터 시작이라 +1을 진행
		int day = cal.get(Calendar.DAY_OF_MONTH); // 1달의 일수가 계산
		int week = cal.get(Calendar.DAY_OF_WEEK); // 요일을 숫자로 출력 1이 일요일
		
		switch(week) {
		case 1 : 
			today = Week.SUNDAY;
			break ;
		case 2 :
			today = Week.MONDAY;
			break ;
		case 3 :
			today = Week.TUESDAY;
			break ;
		case 4 :
			today = Week.WEDNESDAY;
			break ;
		case 5 :
			today = Week.THURSDAY;
			break ;
		case 6 : 
			today = Week.FRIDAY;
			break ; 
		case 7 :
			today = Week.SATURDAY;
			break ;
		}
		
		System.out.println("현재 날짜는 " + year + "년 " + month + "월 " + day + 
				"일 " + today + "입니다.");
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println("현재 시간은 " + hour + "시" + minute + "분" + second + 
				"초 입니다.");
				
		if(today == Week.SUNDAY) {
			System.out.println("일요일입니다. 열심히 집안일을 합시다.");
		}else if(today == Week.MONDAY) {
			System.out.println("월요일입니다. 열심히 자바공부를 합시다.");
		}else if(today == Week.TUESDAY) {
			System.out.println("화요일입니다. 열심히 오라클db공부를 합시다.");
		}else if(today == Week.WEDNESDAY) {
			System.out.println("수요일입니다. 열심히 jsp공부를 합시다.");
		}else if(today == Week.THURSDAY) {
			System.out.println("목요일입니다. 열심히 클라우드 공부를 합시다.");
		}else if(today == Week.FRIDAY) {
			System.out.println("금요일입니다. 열심히 파이썬공부를 합시다.");
		}else if(today == Week.SATURDAY) {
			System.out.println("토요일입니다. 열심히 영화를 봅시다.");
		}

	}//main 메서드 종료

}//class 종료
