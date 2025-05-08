package rrnBuilder;

import java.util.Random;

public class rrnService
{
	// 1. 주민번호 앞자리 생성 메서드 (생년월일 이용) generateFrontNumber(String birth)
	// 2. 주민번호 뒷자리[0] 생성 메서드 (성별 + 출생년도 이용) generateBack0(char gender, String birth)
	// 3. 주민번호 뒷자리[1] 생성 메서드 (출생지 이용) generateBack1(String region)
	// 4. 주민번호 뒷자리[2] 생성 메서드 (출생 시각 이용) generateBack2(int hour)
	// 5. 주민번호 뒷자리[3] 생성 메서드 (출생 분 이용) generateBack3(int minute)
	// 6. 주민번호 뒷자리[4-6] 생성 메서드 (랜덤 3자리 생성) generateBack456()
	// 7. 앞자리+뒷자리를 합쳐 주민번호 완성하는 메서드 combineRRN(int[] front, int[] back)


	
	public int[] generateFrontNumber(String birthday)
	{
		int[] front = new int[6]; // 6자리 배열 생성
		
		for (int i=2; i<8; i++) // 8자리로 받았기 때문에 i=2부터 시작
		{
			front[i-2] = birthday.charAt(i) - '0'; //숫자로 만들기
		}
		
		return front;
	}
	
	public int generateBack0(char gender, String birthday)
	{
		int code = 0;
		
		char century = birthday.charAt(0); // 1이면 1900년대 2면 2000년대생
		boolean isMale = (gender == 'M' || gender =='m');
		
		if(century =='1')
		{
			code = isMale ? 1 : 2; // 1900년대생 남자면 1 아니면 2
		}
		else if(century =='2')
		{
			code = isMale ? 3 : 4; // 2000년대생 남자면 3 아니면 4
		}
		else
		{
			code = 9; //혹시 모를 예외용
		}
		
		return code;
	}
	
	public boolean isValidRegion(String region) // 사용자가 입력할 단어들 예측 이 외에는 재입력 받아야함
	{
	    region = region.trim(); // 혹시 모를 공백 제거

	    // 서울
	    if (region.equals("서울") || region.equals("서울시") || region.equals("서울특별시")) return true;

	    // 부산
	    if (region.equals("부산") || region.equals("부산시") || region.equals("부산광역시")) return true;

	    // 대구
	    if (region.equals("대구") || region.equals("대구시") || region.equals("대구광역시")) return true;

	    // 인천
	    if (region.equals("인천") || region.equals("인천시") || region.equals("인천광역시")) return true;

	    // 광주
	    if (region.equals("광주") || region.equals("광주시") || region.equals("광주광역시")) return true;

	    // 대전
	    if (region.equals("대전") || region.equals("대전시") || region.equals("대전광역시")) return true;

	    // 울산
	    if (region.equals("울산") || region.equals("울산시") || region.equals("울산광역시")) return true;

	    // 세종
	    if (region.equals("세종") || region.equals("세종시") || region.equals("세종특별자치시") || region.equals("세종특별시")) return true;

	    // 경기
	    if (region.equals("경기") || region.equals("경기도")) return true;

	    // 제주
	    if (region.equals("제주") || region.equals("제주시") || region.equals("제주도") || region.equals("제주특별자치도") || region.equals("제주특별시")) return true;

	    // 충청북도
	    if (region.equals("충청북도") || region.equals("충북")) return true;

	    // 충청남도
	    if (region.equals("충청남도") || region.equals("충남")) return true;

	    // 전라북도
	    if (region.equals("전라북도") || region.equals("전북")) return true;

	    // 전라남도
	    if (region.equals("전라남도") || region.equals("전남")) return true;

	    // 경상북도
	    if (region.equals("경상북도") || region.equals("경북")) return true;

	    // 경상남도
	    if (region.equals("경상남도") || region.equals("경남")) return true;

	    // 기타
	    if (region.equals("기타")) return true;

	    return false; // 위 조건에 다 해당 안 되면 잘못된 입력
	}

	
	public int generateBack1(String region)
	{
		region = region.trim(); // 사용자가 실수로 입력한 공백 제거용
		
		// 4글자로 쓴 것 == 경상남도, 경상북도, 이런 것들 경남, 경북 처리 해주기
		if(region.length()==4)
		{
			char first = region.charAt(0);
			char second = region.charAt(1);
			String frontWord = "" + first + second;
			char backWord = region.charAt(2);
			
			if(frontWord.equals("경상"))
			{
				return (backWord == '남') ? 4 : 5; // 경남 4, 경북 5
			}
			if(frontWord.equals("전라"))
			{
				return (backWord == '남') ? 3 : 3; // 전라도는 둘다 3
			}
			if(frontWord.equals("충청"))
			{
				return (backWord == '남') ? 2 : 2; // 충청도도 둘다 2
			}
		}
		
		// 그 외 4글자가 아닌 것들 코드 부여
		if(region.contains("서울")) return 0;
		if(region.contains("경기") || region.contains("인천")) return 1;
		if(region.contains("세종") || region.contains("대전")) return 2;
		if(region.contains("광주")) return 3;
		if(region.contains("부산") || region.contains("울산")) return 4;
		if(region.contains("대구")) return 5;
		if(region.contains("강원")) return 6;
		if(region.contains("제주")) return 7;
		if(region.contains("기타") || region.length() <2) return 8;
		
		return 9; // 최대한 예외처리를 했으나 혹시모를 예비용 예외처리
	}
	
	public int generateBack2(int hour) // 0~2 3~5 6~8 9~11 .. 로 10개로 나눔
	{
		if(hour>=0 && hour<=2) return 0;
		else if(hour<=5) return 1;
		else if(hour<=8) return 2;
		else if(hour<=11) return 3;
		else if(hour<=13) return 4;
		else if(hour<=15) return 5;
		else if(hour<=17) return 6;
		else if(hour<=19) return 7;
		else if(hour<=21) return 8;
		else return 9;
	}
	
	public int generateBack3(int minute) // 0분 부터 59분까지 60개라 6으로 나눔. int기 때문에 소수점 버림처리되서 코드로 사용가능
	{
		return minute / 6;
	}
	
	public int[] generateBack456()
	{
		int[] randomArr = new int[3]; // 랜덤 숫자를 담을 배열 생성
		Random random = new Random(); // 랜덤 객체 불러옴
		
		for(int i=0;i<3;i++) // for문 통해서 randomArr 배열 채우기
		{
			randomArr[i] = random.nextInt(10); // 0~9까지 10개 숫자
		}
		
		return randomArr;
	}
	
	public String combineRRN(int[] frontNumber, int[] backNumber)
	{
		String result = "";
		
		for (int i=0; i<frontNumber.length; i++)
		{
			result += frontNumber[i];
		}
		
		result += "-";
		
		for(int i=0; i<backNumber.length; i++)
		{
			result += backNumber[i];
		}
		
		return result;
	}
	
	// 추가로 넣고 싶은 기능 주민번호는 고유한 번호니까 이걸 배열에 다시 담아서 중복된 숫자가 생성되지 않도록 하고 싶음
}
