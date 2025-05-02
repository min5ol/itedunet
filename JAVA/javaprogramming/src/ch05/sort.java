package ch05;

import java.util.Arrays;

public class sort
{

	public static void main(String[] args)
	{
		int[] sort = {94, 45, 33, 40, 54, 3, 1};
		
		for(int i=0; i<(sort.length-1); i++)
		{
			for(int k=i+1; k<sort.length; k++)
			{
				int tmp = 0;
				if(sort[i]>sort[k])
				{
					tmp = sort[i];
					sort[i] = sort[k];
					sort[k] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(sort));
	}

}
