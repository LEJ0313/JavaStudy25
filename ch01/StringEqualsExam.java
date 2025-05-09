package ch01;

public class StringEqualsExam {

	public static void main(String[] args) {
		String strval1 = "les" ;
		String strval2 = "les" ;
		String strval3 = new String("les") ;  
		
		System.out.println(strval1 == strval2);
		System.out.println(strval1 == strval3);
		
		System.out.println(strval1.equals(strval2));
		System.out.println(strval1.equals(strval3));
		System.out.println(strval2.equals(strval3));
		
	}

}
