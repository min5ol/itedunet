package ch07;

public class exam46
{

	public static void main(String[] args)
	{
		exam46_User user1 = new exam46_User("철수",20);
		exam46_User user2 = new exam46_User("영희",19);
		
		System.out.println(user2.name+"의 나이는 "+user2.age);
		user2.age = 99;
		System.out.println(user2.name+"의 나이는 "+user2.age);
	}

}
