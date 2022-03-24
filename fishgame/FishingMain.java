package java_day22.fishgame;

import java.util.ArrayList;
import java.util.Scanner;

import java_day14_1.UtilClass;

public class FishingMain {
	public static void main(String[] args) {
		ArrayList<Fish> fishList = new ArrayList<Fish>();
		fishList.add(new Fish("멸치", 100));
		fishList.add(new Fish("광어", 200));
		fishList.add(new Fish("도미", 500));
		fishList.add(new Fish("감성돔", 1200));
		fishList.add(new Fish("다금바리", 10000));
		
		ArrayList<Fisher> teamList = new ArrayList<Fisher>();
		teamList.add(new Fisher("1팀"));
		teamList.add(new Fisher("2팀"));
		teamList.add(new Fisher("3팀"));
		teamList.add(new Fisher("4팀"));
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			System.out.println("남은 횟수: " + (10 - i));
			
			for(int j = 0; j < teamList.size(); j++) {
				int idx = 0;
				System.out.println(teamList.get(j).name + " 차례");
				System.out.println("멸치를 잡았습니다. 행동을 선택해주세요.");
				System.out.println("1. 가방에 넣기 | 2. 미끼로 쓰기");
				System.out.print(">>> ");
				
				int select = Integer.parseInt(sc.nextLine());
				
				if(select == 1) {
					teamList.get(j).bag.add(fishList.get(0));
				}else if(select == 2){
					idx++;
					fishing(idx, sc, fishList, teamList.get(j));
				}
				
			}
			
		}
		
		System.out.println("낚시 대회 결과");
		for(int i = 0; i < teamList.size(); i++) {
			System.out.println(teamList.get(i).name);
			System.out.println(teamList.get(i).bag);
			System.out.println("가격: " + sumPrice(teamList.get(i).bag));
		}
		
	}
	
	static void fishing(int index, Scanner sc
			, ArrayList<Fish> fishList, Fisher team) {
		
		if(index >= fishList.size() - 1) {
			System.out.println(fishList.get(index).name + "을 잡았습니다!!");
			team.bag.add(fishList.get(index));
			return;
		}
		
		if(UtilClass.banban()) {
			System.out.println(fishList.get(index).name 
					+ "를 잡았습니다. 행동을 선택해주세요.");
			System.out.println("1. 가방에 넣기 | 2. 미끼로 쓰기");
			System.out.print(">>> ");
			
			int select = Integer.parseInt(sc.nextLine());
			
			if(select == 1) {
				team.bag.add(fishList.get(index));
			}else if(select == 2) {
				index++;
				// 재귀함수, 함수 내에서 해당 함수를 다시 호출
				fishing(index, sc, fishList, team);
			}
		}else {
			System.out.println("물고기를 놓쳤습니다.");
		}
	}
	
	static int sumPrice(ArrayList<Fish> bag) {
		int money = 0;
		for(int i = 0; i < bag.size(); i++) {
			money += bag.get(i).price;
		}
		return money;
			
	}
	
}
