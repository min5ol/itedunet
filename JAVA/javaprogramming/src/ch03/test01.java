package ch03;

public class test01
{

	public static void main(String[] args)
	{
		//문제1. 1 * (1 + 1) = 1 true
		int a = 5;
		int b = 10;
		int c = 15;
		
		System.out.println(!(a>b)&&(b<c||a+b==15));
		
		//문제2. (0 * 0) + (1 * 1) = 1 true
		int x = 25;
		int y = 30;
		int z = 20;
		
		System.out.println((x>=y&&y<z)||(z<x&&x>10));
		
		//문제3. 1 * ( 0 + 1 ) = 1 true
		boolean isMember = true;
		boolean hasDiscount = false;
		boolean isStudent = true;
		
		System.out.println(isMember&&(hasDiscount||isStudent));
		
		//문제4. ((0 * 1)+1)*(0)) = 0 false
		int score1 = 85;
		int score2 = 90;
		int score3 = 75;
		
		System.out.println(((score1>80&&score2>80)||score3<80)&&(score1+score2+score3>250));
		
		//문제5. (1 * 1)+(0*0) = 1 true
		int temperature = 30;
		boolean isSunny = true;
		boolean isHoliday = false;
		
		System.out.println((temperature>25&&isSunny)||(temperature<=25&&isHoliday));
		
		//문제6. 0 * (1 + 0) = 0 false
		int num1 = 12;
		int num2 = 8;
		int num3 = 4;
		
		System.out.println(!(num1%2==0)&&(num2>num3||num1==num3));
		
		//문제7. 0 + (1 * 1) = 1 true
		boolean isOpen = false;
		boolean hasKey = true;
		boolean isGuest = false;
		
		System.out.println(isOpen||(hasKey&&!isGuest));
		
		//문제8. (1 * 1) + (0 * 1) = 1 true
		int age = 25;
		boolean isEmployed = true;
		boolean hasDegree = false;
		
		System.out.println((age>=18&&isEmployed)||(hasDegree&&age<30));
		
		//문제9. !(0 * 1) = 1, 1 + 0 = 1 true
		String input = "java";
		boolean isLearning = true;
		boolean isFun = false;
		
		System.out.println(!(input.equals("python")&&isLearning)||isFun);
		
		//문제10. ((0 * 0) + 1)) * (1) = 1 true
		int d = 10;
		int e = 20;
		int f = 5;
		
		System.out.println(((d+e>f&&e-f<d)||(f==5))&&(d*f>e));
	}

}
