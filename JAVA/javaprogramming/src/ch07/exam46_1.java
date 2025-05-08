package ch07;

public class exam46_1
{
	public static void main(String[] args)
	{
		exam46_1_User user1 = new exam46_1_User("철수",20);
		exam46_1_User user2 = new exam46_1_User("영희",19);
		
		user2.setAge(20);
		System.out.println(user2.getName()+"의 나이는 "+user2.getAge());
	}
}
