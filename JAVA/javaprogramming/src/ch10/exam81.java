package ch10;

import java.time.LocalDate;

public class exam81
{

	public static void main(String[] args)
	{
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		LocalDate ld2 = ld
				.minusYears(2)
				.plusMonths(3)
				.minusDays(4);
		System.out.println(ld2);
		
		LocalDate ld3 = ld2.minusDays(3);
		System.out.println(ld3);
		
		LocalDate ld4 = ld3.plusWeeks(3);
		System.out.println(ld4);
	}

}
