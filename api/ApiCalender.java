package java_day22.api;

import java.util.Calendar;

public class ApiCalender {
	public int year; // 사용자가 보려는 년도
	public int month; // 사용자가 보려는 달
	public int lastDay; // 해당 달의 마지막 날짜(일)
	public int startWeek; // 해당 달의 시작 요일

	ApiCalender(int year, int month) {
		this.year = year;
		this.month = month;
	}

	public void ready() {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1); // ApiCalender를 생성하며 입력받은 날짜 세팅

		this.lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 입력받은 달의 마지막 일 수 계산
		this.startWeek = cal.get(Calendar.DAY_OF_WEEK); // 입력받은 달의 시작 요일. 1: 일요일, 2: 월요일, ... 7: 토요일
	}

	// 토요일은 파란색, 일요일은 빨간색으로 업그레이드
	public void drawAll() {
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		int day = 1;

		for (int i = 1; i <= 42; i++) {
			if (i < startWeek) {
				System.out.print("\t");
			} else {
				// "%2d"
				// 2자리보다 작으면 여백을 추가해서 2자리를 확보 합니다. 예 _1 (_는 0x20, 스페이스, 여백을 의미)
				// 2자리보다 크면 그대로 출력됩니다. 예 "12345"
				System.out.printf("%2d\t", day);
				day++;

				if (day > lastDay) {
					break;
				}
			}

			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}

	public void drawWeekDay() {
		System.out.println("월\t화\t수\t목\t금");

		int day = 1;

		for (int i = 1; i <= 42; i++) {
			if (i < startWeek) {
				if (!(i % 7 == 1 || i % 7 == 0)) {
					System.out.print("\t");
				}
			} else {
				if (!(i % 7 == 1 || i % 7 == 0)) {
					System.out.printf("%2d\t", day); // 우로 정렬
				}

				day++;

				if (day > lastDay) {
					break;
				}
			}

			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}

}