package ch10;

import java.text.SimpleDateFormat;
import java.util.Date;

public class exam80
{

	public static void main(String[] args)
	{
		Date day = new Date();
		
		System.out.println("현재 날짜" + day);
		
		String patternKorea = "yyyy-MM-dd";
		SimpleDateFormat p1 = new SimpleDateFormat(patternKorea);
		System.out.println("한국 형식(년,월,일): "+p1.format(day));
		
		String patternUSA = "MM-dd-yyyy";
		SimpleDateFormat p2 = new SimpleDateFormat(patternUSA);
		System.out.println("미국 형식(월,일,년): "+p2.format(day));
		
		String patternUK = "dd-MM-yyyy";
		SimpleDateFormat p3 = new SimpleDateFormat(patternUK);
		System.out.println("영국 형식(일,월,년): "+p3.format(day));
		
	}

}
