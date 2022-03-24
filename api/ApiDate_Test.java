package java_day22.api;

import java.util.Calendar;

public class ApiDate_Test {
	private int year;
	private int month;
	private int lastDay;
	private int StartDay;

	public ApiDate_Test(int year, int month) {
		super();
		this.year = year;
		this.month = month;
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(year, month - 1, 1);
		
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		StartDay = cal.get(Calendar.DAY_OF_WEEK);
	}

	public void drawCal() {
		
		System.out.println(year + "년" + month + "월 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		int curDay = 1;

		for (int i = 0; i < 42; i++) {
			if (i >= StartDay) {
				System.out.printf("%2d\t", curDay);
				curDay++;

				if (curDay > lastDay) {
					break;
				}
			} else {
				System.out.print("\t");
			}

			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}
}
