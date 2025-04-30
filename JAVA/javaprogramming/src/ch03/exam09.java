package ch03;

public class exam09
{

	public static void main(String[] args)
	{
		double a = 3.14;
		double b = 5.14;
		
		System.out.println(a==b);
		System.out.println(a!=b);
		
		String c1 = "Hello JAVA!";
		
		System.out.println(c1.equals("Hello java!"));
		System.out.println(c1.equals("Hello JAVA!"));
		System.out.println(c1==("Hello JAVA!"));
		// 실제로는 false가 나와야한다. c1은 값을 가진게 아닌 주소를 가지고 있는 참조변수이기 때문
	}

}
