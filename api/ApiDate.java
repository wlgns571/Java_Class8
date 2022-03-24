package java_day22.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import java_day23.api.ApiMath_Test;

public class ApiDate {

	public static void main(String[] args) throws ParseException {
		/* 현재 시간 */
		// Date 클래스 사용
		Date dateToday = new Date();
		System.out.println(dateToday);

		// 날짜 포맷 설정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시mm분ss.SSS초");
		String strToday = dateFormat.format(dateToday);
		System.out.println(strToday);

		// Calendar 클래스 사용
		Calendar calToday = Calendar.getInstance(); // 싱글톤 형식
		System.out.println(calToday);
		System.out.println("asdfsafsdafffsafsafsfsf");
		System.out.println(calToday.getTime());
		strToday = dateFormat.format(calToday.getTime());
		System.out.println(strToday);

		// System 클래스 사용
		System.out.println(System.currentTimeMillis()); // UTC 1970-01-01 기준으로 현재까지의 밀리초
		strToday = dateFormat.format(System.currentTimeMillis());
		System.out.println(strToday);

		System.out.println("\n=======================================\n");

		/* 다양한 날짜 타입 만들기 */
		// 오전 or 오후 디지털 시계
		System.out.println(resultDate("a hh:mm:ss"));
		// 요일까지 나타내는 시계
		System.out.println(resultDate("E a hh:mm:ss"));
		System.out.println(resultDate("E요일, a hh:mm:ss"));
		System.out.println(resultDateEng("E, a hh:mm:ss")); // SimpleDateFormat의 Locale 설정으로 한/영 설정이 가능하다.
		// 많이 쓰는 날짜 타입
		System.out.println(resultDate("yyyy.MM.dd HH:mm:ss.SSS"));
		System.out.println(resultDate("yyyy/MM/dd HH:mm:ss.SSS"));
		System.out.println(resultDate("yyyy-MM-dd HH:mm:ss.SSS"));
		System.out.println(resultDate("yyyyMMddHHmmssSSS"));
		// 해외 시간
		System.out.println(foreignDate("E요일, a hh:mm:ss")); // 한국보다 14시간 느린 미국 시간
		// TimeZone 에 들어있는 아이디 조회
//		String[] local = TimeZone.getAvailableIDs();
//		for (int i = 0; i < local.length; i++) {
//			System.out.println(local[i]);
//		}

		System.out.println("\n=======================================\n");

		/* 날짜 <-> 문자열 바꾸기 */
		String strTomorrow = "2022-02-04 10:00:30";
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTomorrow = dateFormat.parse(strTomorrow); // 문자열을 Date 타입으로 변환
		System.out.println(dateTomorrow);

		strTomorrow = "11:20:30";
		dateFormat = new SimpleDateFormat("HH:mm:ss"); // 문자열을 날짜 형식으로 바꿀 때, DateFormat을 문자열에 맞춰주어야 한다.
		dateTomorrow = dateFormat.parse(strTomorrow);
		System.out.println(dateTomorrow); // 문자열에 포함되어있지 않은 연,월,일은 기본값인 1970-01-01 로 맞춰진다.

		strTomorrow = "2022.02.03";
		dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		dateTomorrow = dateFormat.parse(strTomorrow);
		System.out.println(resultDate(dateTomorrow, "yyyy-MM-dd HH:mm:ss.SSS")); // 문자열에 포함되어있지 않은 시,분,초,밀리초는 기본값인 0으로
																					// 맞춰진다.

		// 간단하게 날짜 세팅하기
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		calToday.set(2021, 2, 3, 12, 47, 20); // 연, 월, 일, 시, 분, 초 순서이며 월의 경우 1월이 0이므로, 원하는 날짜에서 1을 뺀 값을 넣어주어야 한다. (3월 =
												// 2)
		System.out.println(dateFormat.format(calToday.getTime()));

		// Date를 Calendar로 변환
		calToday.setTime(dateTomorrow);
		System.out.println(dateFormat.format(calToday.getTime()));

		System.out.println("\n=======================================\n");

		/* 날짜 연산 */
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		long diffDate = dateToday.getTime() - dateTomorrow.getTime(); // Date 객체간 연산은 getTime을 이용하여 밀리초 단위로 바꿔준 후 연산한다.
		long diffMin = diffDate / (1000 * 60);
		System.out.println("내일까지 " + (diffMin / 60) + "시간 " + (diffMin % 60) + "분 남았습니다.");
		
		System.out.println("\n=================== Calendar ====================\n");
		// Calendar 사용
		// Calendar의 getInstance()는 싱글톤이 아니라
		// 새로운 Calendar 객체를 생성하는 것입니다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Calendar calTest = Calendar.getInstance();
		// new Date() 처럼 실행될 당시의 시간이 세팅된 객체가 생성됨.
		System.out.println(sdf.format(calTest.getTime()));
		
		calTest.add(Calendar.DATE, 1);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Calendar calTest2 = Calendar.getInstance();
		System.out.println(sdf.format(calTest2.getTime()));
		System.out.println(calTest.hashCode());
		System.out.println(calTest2.hashCode());
		
		// window - preferences - java - code style - code templates - code - method body > 주석제거
		
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime())); // 싱글톤이라 변수를 바꿔도 같은 Calendar 객체를 가져온다.
		cal.setTime(new Date()); // Calendar 의 날짜 초기화(오늘 날짜로)

		// 하루 뒤
		cal.add(Calendar.DATE, 1);
		System.out.println(dateFormat.format(cal.getTime()));
		// 세달 뒤
		cal.add(Calendar.MONTH, 3);
		System.out.println(dateFormat.format(cal.getTime())); // 하루가 더해진 날짜가 유지된 상태로 세 달이 더해진다.

		// Calendar를 Date로 변환
		Date mayDate = cal.getTime();
		System.out.println(dateFormat.format(mayDate));

		System.out.println("\n=======================================\n");

		/* 달력 만들기 */
		int year = 2022;
		int month = 4;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		System.out.println(sdf.format(calendar.getTime()));
		
		// 해당달의 마지막 일(DATE)을 리턴
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastDay);
		
		// 해당달의 시작 요일 (1: 일요일 , 2: 월요일 ... 7.토요일)
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(startDay);
		
		System.out.println(year + "년" + month + "월 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		int currentDay = 1;
		
		for (int i = 0; i < 42; i++) {
			if (i >= startDay) {
				System.out.printf("%2d\t", currentDay);
				currentDay++;
				
				if (currentDay > lastDay) {
					break;
				}
			} else {
				System.out.print("\t");
			}
			
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println("\n=======================================\n");
		
		ApiCalender apiCal = new ApiCalender(2022, 3);
		apiCal.ready();
		apiCal.drawAll();

		System.out.println("\n=======================================\n");

		apiCal.drawWeekDay();
		
		System.out.println("\n=============== Dday 계산 =====================\n");
		System.out.println("개원 기념일 까지 D-day = " + calDday("2022.04.01"));
		System.out.println("학원 처음 온날부터 " + calDday("2022.02.14") + "일 지남");
		
		System.out.println("\n=============== 달력 계산 =====================\n");
		
		ApiDate_Test apiCal2 = new ApiDate_Test(2022, 6);
		apiCal2.drawCal();
		
		System.out.println("\n===========================================\n");
		
		System.out.println("Guest" + ApiMath_Test.makeUniqueId() +  "님 환영합니다.");
		System.out.println("Guest" + ApiMath_Test.makeUniqueId() +  "님 환영합니다.");
		System.out.println("Guest" + ApiMath_Test.makeUniqueId() +  "님 환영합니다.");
	}
	

	// Dday 계산기
	static long calDday(String dday) throws ParseException {
		// 오늘 날짜 구하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date today = new Date();	// 2022.03.17 16:33:30
		// 2022.03.18 00:00:00 - 2022.03.17 16:33:30 = 8시간(X)
		// 2022.03.17 00:00:00으로 만들어 주어야 날짜(일) 계산 용이
		String strToday = sdf.format(today);
		// strToday = 2022.03.17만 들어가게 됨 (문자열)
		Date sdfToday = sdf.parse(strToday);
		// sdfToday = 2022.03.17 00:00:00 세팅된 Date 객체
		
		Date inputDay = sdf.parse(dday);
		
		long diffMillSec = inputDay.getTime() - sdfToday.getTime();
		long diffDay = diffMillSec / (1000 * 60 * 60 * 24);
		
		return diffDay;
 	}
	
	// 사용자 지정 형식(format)을 따르는 오늘 날짜 리턴
	static String resultDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);
	}

	// 메소드 오버로딩
	// 사용자 지정 형식(format)을 따르는 사용자 입력 날짜 리턴
	static String resultDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	// dateFormat을 영어로 출력(오전/오후 -> AM/PM)
	static String resultDateEng(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
		Date date = new Date();
		return sdf.format(date);
	}

	static String foreignDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
		sdf.setTimeZone(timeZone);
		Date date = new Date();
		return sdf.format(date);
	}

}