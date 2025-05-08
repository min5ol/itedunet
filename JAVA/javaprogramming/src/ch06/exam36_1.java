package ch06;

public class exam36_1
{
	static void manual()
	{
		System.out.println("현재 사용 가능한 함수 목록");
		System.out.println("triangle: 삼각형 넓이");
		System.out.println("rectangle: 사각형 넓이");
		System.out.println("입니다.");
	}
	
	double triangle(int a, int b)
	{
		return (double)a*b/2;
	}
	
	int rectangle(int a, int b)
	{
		return a*b;
	}
}
