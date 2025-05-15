package ch10;

import java.util.Random;

public class exam74
{

	public static void main(String[] args)
	{
		Random random = new Random();
		Random random2 = new Random();
		Random random3 = new Random();
		
		for(int i = 0; i<5; i++)
		{
			System.out.println("기본 생성자: "+random.nextInt());
		}
		
		for(int i=0;i<5;i++)
		{
			int a = random2.nextInt(11)+20;
			System.out.println("random2: "+(i+1)+"번째 값 "+a);
		}
		
		for(int i=0;i<5;i++)
		{
			int b = random3.nextInt(51)+100;
			System.out.println("random3: "+(i+1)+"번째 값 "+b);
		}
		
	}

}
