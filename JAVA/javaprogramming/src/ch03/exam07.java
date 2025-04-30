package ch03;

public class exam07
{

	public static void main(String[] args)
	{
		int a = 1;
		System.out.println(a); // a = 1
		
		a++; // a = 2
		System.out.println(a); // a = 2
		System.out.println(++a); // a = 3 (먼저 증가)
		System.out.println(a++); // a = 3 (다음 줄 부터 증가 적용)
		System.out.println(a); // a = 4 (14번라인에서 증가 적용된거 15번 라인에 적용되어 표시)
	}

}
