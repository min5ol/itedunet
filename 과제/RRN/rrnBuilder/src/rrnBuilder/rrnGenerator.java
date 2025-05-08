package rrnBuilder;

import java.util.Scanner;

public class rrnGenerator
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		rrnService service = new rrnService();
		
		// 사용자가 입력한 값을 받을 변수
		String birthday;
		char gender;
		String region;
		int hour;
		int minute;
		
		// 위 변수를 바탕으로 실제 주민번호 생성에 사용될 배열
		int frontNumber[] = new int[6];
		int backNumber[] = new int[7];

		
		// 1. 태어난 날짜 입력받기
		while(true)
		{
			// 8가지 문자열로 받는 이유 첫자리가 1일 경우 뒷자리 예시 1,2
			// 첫자리가 2일 경우 뒷자리 예시 3,4로 분기하기 위함
			System.out.println("태어난 날짜를 입력하세요(예시: 19990621) : ");
			birthday = sc.nextLine();
			
			
			// 8자리인지 확인
			if (birthday.length() !=8)
			{
				System.out.println("8자리로 입력해주세요. : ");
				continue; // 8자리 아니면 돌아가 처음으로
			}
			
			
			// 숫자인지 확인
			boolean isNumber = true;
			
			for(int i=0;i<8;i++)
			{
				char ch = birthday.charAt(i); // 8자리 문자열 하나씩 쪼개기
				
				if(ch<'0' || ch>'9')
				{
					isNumber = false; // 하나라도 문자일시 false 처리 후 
					break; // for문 중단
				}
			}
			
			if(isNumber) // 문자가 없을 시 while문 빠져나오기
			{
				break;
			}
			
			System.out.println("숫자만 입력해주세요. : "); // for문 중단 후 오는 곳
		}
		
		// 2. 성별 받기
		while (true)
		{
			System.out.println("성별을 입력하세요 (M / F) : ");
			String genderInput = sc.nextLine(); //문자열로 받아야 해서 새로운 참조변수 생성
			
			if (genderInput.length() != 1) // 1글자가 아닐때
			{
				System.out.println("한 글자만 입력해주세요. : ");
				continue;
			}
			
			char g = genderInput.charAt(0); // 한글자니까 char 변수에 담고
			if(g == 'M' || g == 'F' || g == 'm' || g == 'f') // m또는 f가 true일때만
			{
				gender = g; // 변수에 담기
				break; // 그리고 탈출
			}
			
			// 분명 이걸 upper나 이런식으로 받는 방법이 있었던 것 같은데 나중에 배우면 업그레이드 시킬게여
			
			System.out.println("M 또는 F로 입력해주세요. : "); // 문자 1개가 M또는 F가 아닐 경우
		}
		
		
		
		
		
//		while (true)
//		{
//			System.out.println("태어난 지역을 입력하세요 (예: 서울시, 경상남도, 기타, 광역시 제외 도로 작성, 해외일 시 기타 입력) : ");
//			region = sc.nextLine();
//			
//			// 지역명 앞글자 2개만 따서 코드 부여할 예정(다른클래스에서 매핑)
//			// 유효성 검사
//			
//			if(region.length() < 2)
//			{
//				System.out.println("두 글자 이상 입력해주세요. : ");
//				continue;
//			}
//			
//			char first = region.charAt(0);
//			char second = region.charAt(1);
//			String keyword = "" + first + second;
//			
//			if (keyword.equals("서울") || keyword.equals("부산") || keyword.equals("대구") ||
//				keyword.equals("인천") || keyword.equals("광주") || keyword.equals("대전") ||
//				keyword.equals("울산") || keyword.equals("세종") || keyword.equals("경기") ||
//				keyword.equals("기타")
//				)
//			{
//				break;
//			}
//			
//			System.out.println("정확한 지역명을 입력해주세요. (예: 서울특별시, 경기도, 기타 등) : ");
//		}
		// 생각해보니 이렇게 하면 지역을 10가지로 나눌수 있지만 제주를 기타로 포함해야하는 등 제대로 나눌수 없어서 새로운 로직 작성하기로함
		// 제 리팩토링 과정을 보여드리기 위해 일부러 삭제 안하고 주석처리 해두었습니다.
		
		
		
		// 3. 출생지 입력받기
		while(true)
		{
			System.out.println("태어난 지역을 입력하세요.");
			System.out.println("예: 서울특별시, 서울시, 경상남도, 전북 등.(해외는 기타로 입력) : ");
			
			region = sc.nextLine();
			
			if(region.length() < 2)
			{
				System.out.println("두 글자 이상 입력해주세요.");
				continue;
			}
			
			// 지역 유효성 검사 다른 클래스에서 로직으로 처리
			if(service.isValidRegion(region))
			{
				break;
			}
			
			System.out.println("정확한 지역명을 입력해주세요. 예: 서울특별시, 경상남도, 경북, 기타");
		}
		
		// 4. 출생시간 입력받기
		
		while (true)
		{
			System.out.println("태어난 시간 (0~23)을 입력하세요. : ");
			String hourInput = sc.nextLine(); //nextInt로 안받은 이유: 사용자가 엔터처리해서 문자열 입력 바로 안받아지는거 방지용
			
			// 숫자인지 검사
			boolean isNumbering = true;
			for(int i = 0; i<hourInput.length(); i++)
			{
				char ch = hourInput.charAt(i);
				if (ch < '0' || ch > '9')
				{
					isNumbering = false;
					break;
				}
			}
			
			if(!isNumbering) // 컨티뉴 구문때문에 if를 한번 더 사용, 더 줄일 수 없는지 고민해봤으나 지금 나의 지식으론 이것이 가장 안정적이라고 생각
			{
				System.out.println("숫자만 입력해주세요. : ");
				continue;
			}
			
			int h = Integer.parseInt(hourInput);
			if (h >= 0 && h<=23) // 범위 모두 만족해야만 변수안에 대입가능
			{
				hour = h;
				break;
			}
			
			System.out.println("0부터 23 사이의 값을 입력해주세요. : ");
		}
		
		// 분 입력(시 입력과 변수 제외 모두 같으므로 주석 생략)
		while (true)
		{
			System.out.println("태어난 분 (0~59)을 입력하세요 : ");
			String minInput = sc.nextLine();
			
			boolean isNumbering2 = true;
			for(int i=0;i<minInput.length();i++)
			{
				char ch = minInput.charAt(i);
				if(ch<'0'||ch>'9')
				{
					isNumbering2 = false;
					break;
				}
			}
			
			if(!isNumbering2)
			{
				System.out.println("숫자만 입력해주세요. : ");
				continue;
			}
			
			int m = Integer.parseInt(minInput);
			if(m>=0 && m<=59)
			{
				minute = m;
				break;
			}
			
			System.out.println("0부터 59 사이의 값을 입력해주세요. : ");
		}
		
		// 서비스 클래스에서 로직 처리 후 주민번호 배열 채우기
		frontNumber = service.generateFrontNumber(birthday);
		
		backNumber[0] = service.generateBack0(gender, birthday);
		backNumber[1] = service.generateBack1(region);
		backNumber[2] = service.generateBack2(hour);
		backNumber[3] = service.generateBack3(minute);
		
		int[] back456 = service.generateBack456();
		backNumber[4] = back456[0];
		backNumber[5] = back456[1];
		backNumber[6] = back456[2];

		// 주민번호 담는 변수 생성 후 서비스클래스의 주민번호 합하는 메서드 사용
		String rrn = service.combineRRN(frontNumber, backNumber);
		
		System.out.println("생성된 주민등록번호: " + rrn);
	}

}


// 고찰
// 1. char century == birthday.charAt(0); 을 1과 2로만 비교해야했으나
// birthday를 처음에는 6자리로 설계했던것과 혼돈하여 9와 0으로 비교해서 에러가났음

//2. int backNumber[0] = 으로 선언하고 초기화하려했음 자바는 개별인덱스를 선언과 동시에 초기화 할수 없음을 깨달음

//3. 에러는 아니지만 알게된점 같은 패키지 내에서는 import 하지 않아도됨.

//4. 성별 입력시 사용자가 대문자만을 입력하지 않을 것 같아서 m과 f도 허용시킴, 자바스크립트처럼 Upper같은 구문이 있을 것으로 추정