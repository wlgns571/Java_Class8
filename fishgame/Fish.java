package java_day22.fishgame;

public class Fish {
	String name;		// 물고기 이름
	int price;			// 물고기 가격
	
	public Fish(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", price=" + price + "]";
	}
	
	
}
