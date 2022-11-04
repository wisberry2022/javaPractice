package classSet;
import java.util.ArrayList;

public class Nation {
	private String name;
	private int pop;
	private String capitalCity;
	private ArrayList<String> developList = new ArrayList<>();
	
	public Nation() {
		this.name = "Unknown";
		this.pop = 0;
		this.capitalCity = "Unknown";
	}
	
	public Nation(String name, int pop, String capital) {
		this.name = name;
		this.pop = pop*10000;
		this.capitalCity = capital;
	}
	
	public void getNation() {
		System.out.println("국가이름 : " + this.name + "\n" + "인구수 : " + this.pop + "\n" + "수도 : " + this.capitalCity + "\n");
		for(int i = 0; i<this.developList.size(); i++) {
			System.out.println(this.name + "의 보유기술 목록 : " + this.developList.get(i));
		}
	}
	
	public void setNation(String name, int pop, String capital) {
		this.name = name;
		this.pop = pop*10000;
		this.capitalCity = capital;
	}
	
	public void developTech(String techName) {
		this.developList.add(techName);
	}
	
	public void war(Nation nation) {
		System.out.println(this.name + "이 " + nation.name + "과 전쟁을 시작했습니다!");
	}
}
