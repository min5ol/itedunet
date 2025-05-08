package ch06;

public class exam34
{

	public static void main(String[] args)
	{
		System.out.println(exam34_1.wheel);
		
		exam34_1 myCar1 = new exam34_1();
		
		System.out.println(exam34_1.wheel);
		System.out.println(myCar1.speed);
		
		exam34_1 myCar2 = new exam34_1();
		
		System.out.println("<변경 전>");
		System.out.println("myCar1.speed: "+myCar1.speed);
		System.out.println("myCar2.speed: "+myCar2.speed);
		System.out.println("myCar1.wheel: "+myCar1.wheel);
		System.out.println("myCar2.wheel: "+myCar2.wheel);
		
		myCar2.speed = 100;
		myCar2.wheel = 5;
		System.out.println("<변경 후>");
		System.out.println("myCar1.speed: "+myCar1.speed);
		System.out.println("myCar2.speed: "+myCar2.speed);
		System.out.println("myCar1.wheel: "+myCar1.wheel);
		System.out.println("myCar2.wheel: "+myCar2.wheel);
	}

}
