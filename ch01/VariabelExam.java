package ch01;

public class VariabelExam {

	public static void main(String[] args) {
		
		int mach ;
		int distance ;
		mach = 340 ;
		distance = mach * 60 * 60 ; // ���� m/s�� �����
		
		System.out.println("�Ҹ��� 1�ð����� ���� �Ÿ�");
		System.out.println(distance + "m");
		
		double radius ; // �Ǽ� Ÿ���� radius ���� ����
		double area ; // �Ǽ� Ÿ���� area ���� ����
		// �Ǽ� Ÿ���� �Ҽ����� �ִ� (double = �Ҽ��� ó��)
		
		radius = 10 ; // �ʱⰪ�� ���������� double ������ �Ҽ���(�Ǽ�)���� ��ȯ��
		area = radius * radius * 3.14 ; // ���� ���� ���
		
		System.out.print("�������� " + radius + "��");
		System.out.println(" ���� ���� = " + area);
		// ln = �ٳ����� 

	}

}
