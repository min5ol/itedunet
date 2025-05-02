package ch05;

public class exam28
{

	public static void main(String[] args)
	{
		int[] student = {100, 95, 90, 88, 93};
		
		int sum = 0;
		
		for(int i = 0; i<student.length; i++)
		{
			sum+=student[i];
		}
		
		System.out.println("시험 점수의 평균 : " + sum/(float)student.length);
	}

}