package ch04;

public class test01
{
	public static void main(String[] args)
	{
		System.out.println("구구단\n");
		
		for(int i = 1; i < 10; i++)
		{
			for(int k = 2; k < 10; k++)
			{
				System.out.printf("%d X %d = %d\t",k,i,i*k);
			}
			System.out.println("");
		}
	}
}