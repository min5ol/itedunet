package ch04;

import java.util.Scanner;

public class exam23
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String answer = "Y";
		int count = 0;
		
		do
		{
			System.out.println("음악을 재생하시겠습니까?(Y/N)");
			answer = sc.nextLine();
			
			if(answer.equals("Y"))
			{
				System.out.printf("음악을 %d번 재생했습니다.", ++count);
			}
		} while(answer.equals("Y"));
		System.out.println("재생 종료");
	}

}
