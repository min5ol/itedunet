package ch07;

public class exam40_1
{
	void breath()
	{
		System.out.println("숨쉬기");
	}
	
	void eat()
	{
		System.out.println("밥먹기");
	}
	
	void say()
	{
		System.out.println("말하기");
	}
}

class Student extends exam40_1 
{
	@Override
	public void breath()
	{
		System.out.println("숨 크게쉬기");
	}
	
	void learn()
	{
		System.out.println("배우기");
	}
}

class Teacher extends exam40_1
{
	void teach()
	{
		System.out.println("가르치기");
	}
}