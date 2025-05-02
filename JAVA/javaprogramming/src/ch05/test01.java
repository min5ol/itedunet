package ch05;

import java.util.Scanner;

public class test01
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("배열의 갯수를 입력해주세요!");
		
		int count = sc.nextInt();
		int[]a = new int[count];

		//배열 입력
		for(int i=0; i<a.length; i++)
		{
			System.out.println(i+"번째의 값을 입력해주세요!");
			a[i] = sc.nextInt();
		}
		
		//배열 출력
		for(int i=0; i<a.length; i++)
		{
			System.out.println(i+"번째 저장된 값은: "+a[i]);
		}
	}

}
