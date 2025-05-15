package ch10;

import java.util.Calendar;
import java.util.Scanner;

public class exam70
{

	public static void main(String[] args)
	{
		Calendar a = Calendar.getInstance();
		
		int year = a.get(Calendar.YEAR);
		int month = a.get(Calendar.MONTH);
		int date = a.get(Calendar.DATE);
		
		System.out.println(year+"년"+month+"월"+date+"일");
		System.out.println(a.get(Calendar.DAY_OF_WEEK));
		System.out.println(a.get(Calendar.DAY_OF_YEAR));
		System.out.println(a.getActualMaximum(Calendar.DATE));

	}

}
