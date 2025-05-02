package ch00;

import java.util.Random;
import java.util.Scanner;

public class RRNgenerator
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in); // 사용자에게 값을 받기 위해 스캐너 객체 사용
		Random random = new Random(); // 주민번호 뒷자리 3개 랜덤으로 사용하기 위해 랜덤 객체 사용
		
		// 사용자의 정보를 담기위한 변수
		String birth;
		char gender;
		String region;
		int hour;
		int minute;

		// 주민번호의 앞자리와 뒷자리를 담기위한 배열
		int frontNumber[] = new int[6];
		int backNumber[] = new int[7];
		
		// 사용자 정보 받기
		
		// 1. 생년월일
		
		while(true)
		{
			System.out.println("생년월일을 입력하세요(예: 19990621) : ");
			birth = sc.nextLine();
			
			// 8자리 숫자인지 확인
			if(birth.length()!=8)
			{
				System.out.println("8자리를 입력해주세요.");
				continue;
			}
			
			boolean isNumber = true;
			for(int i = 0; i<8; i++)
			{
				char ch = birth.charAt(i);
				if(ch<'0'||ch>'9')
				{
					isNumber = false;
					break;
				}
			}
			
			if(isNumber) break;
			
			System.out.println("숫자만 입력해주세요.");
		}
	}

}
