package ch01;

public class VatExam {

	public static void main(String[] args) {
		
		// ���� ���� �׽�Ʈ
		// int = ����Ÿ��, char = ����Ÿ��
		int x = 1 ; // x������ 1�� �ִ´�.
		
		char y = 65 ; // char�� ����Ÿ���ε� ���ڷ� ��ȯ�Ǳ⵵ ��
					  // ��ǻ�ʹ� ���ڸ� �����ڵ�� ��ȯ�ؼ� ó���Ѵ�
					  // �����ڵ� ǥ���� 65�� A�� �ǹ��Ѵ�
		
		char z = 'A' ; // char Ÿ���� z ������ ���� A�� �ִ´�.
					   // ''�� ���� ���� -> ���ڸ� �־���ϱ� ����
		
		System.out.println("int x : " + x);
		System.out.println("char y : " + y);
		System.out.println("char z : " + z);
		
		char z1 = 'b' ; 
		// ���ڷ� ������ ���ڿ��� ������ ����
		
		// ������ ����
		int x1 ; // �ʱ�ȭ �ȵ� ����
		x1 = 10 ; 
		System.out.println(x1);
		
		//���� ���� ����
		int kor, mat, eng, total, avg ;
		kor = 91 ; 
		mat = 80 ; 
		eng = 70 ; 
		total = kor + mat + eng ; //����
		avg = total /3 ; //���
		
		System.out.println("���� : " + total);
		System.out.println("��� : " + avg);
		// �ڵ�� ������ �ƴ����� ��� ���� �Ҽ����� �����
		// ������ �����ϴ� �ڵ����� ������ ����� �ִ�.
		
		// ���� �ۼ� ��Ģ
		// ������ ������ �����̿��� �Ǹ� $, _�� ����� �� �ִ�
		// ���ʷ� ù���� ������ �ҹ��ڷ�, �ι�° �ܾ���ʹ� �빮�ڷ� �����Ѵ�
		
		int prise, $prise, _prise ; // �������̸� Ư������ ������ ��
		
		char firstname = '��' ; 
		char firstName = '��' ; 
		
		System.out.println("�� : " + firstname);
		System.out.println("�� : " + firstName);
		// �������� ��ҹ��ڴ� �ٸ� ������ �ν��Ѵ�.
		
		// ������ ������ ����� �� ����.
		// ������ �ڹٿ��� �̹� ������� ����(����, Ŭ����, �����ִ� �ܾ�)
		
		//���ͷ� : ���� �Էµ� �� !
		int literal1 = 75 ;     //10����
		int literal2 = 075 ;    // 8����
		int literal3 = 0b0011 ; // 2����
		int literal4 = 0xA ;    // 16����
		
		System.out.println("10���� 75 : " + literal1);
		System.out.println("8���� 075 : " + literal2);
		System.out.println("2���� 0b0011 : " + literal3);
		System.out.println("16���� 0xA : " + literal4);
		
		
	}

}
