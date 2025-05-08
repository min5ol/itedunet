package ch06;

public class exam36
{

	public static void main(String[] args) 
	{
		exam36_1.manual();
		
		exam36_1 cal = new exam36_1();
		
		cal.manual();
		System.out.println(cal.triangle(3,5));
		System.out.println(cal.rectangle(3,4));
	}

}
