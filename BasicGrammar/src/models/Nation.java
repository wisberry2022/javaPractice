package models;
import java.util.ArrayList;

public class Nation {
	private String name;
	private int pop;
	private String capitalCity;
	private ArrayList<String> developList = new ArrayList<>();
	private boolean attackedICBM = false;
	
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
	
	public void developTech(String techName) {
		this.developList.add(techName);
	}
	
	private boolean getDevelop(String development) {
		return this.developList.contains(development);
	}
	
	private void deadPop(int Pop) {
		System.out.println(this.name + "이 핵미사일의 피해로 인해" + Pop*10000  + "명이 죽었습니다!");
		this.pop -= Pop*10000;
		System.out.println(this.name + "이 핵미사일의 피해로" + this.pop + "명만 남았습니다!");
	}
	
	private void launchICBM(String nation, Nation target) {
		new Thread(new Runnable() {
			public void run() {
				try {
					for (int i = 5; i>0; i--) {
						Thread.sleep(1000);
						System.out.println("발사 대기 .. " + i + "초 남음");
					}
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(nation + "이 핵미사일을 발사하였습니다!");
				target.deadPop(30);
			}
		}).start();
	}
	
	
	
	public void attackedNuclear() {
		if (this.attackedICBM) {
			
		}
	}
	
	public void war(Nation nation) {
		System.out.println(this.name + "이 " + nation.name + "과 전쟁을 시작했습니다!");
		String nationWithICBM;
		boolean hasICBM = false;
		if (this.getDevelop("탄도미사일 발사 기술")) {
			nationWithICBM = this.name;
			hasICBM = true;
			this.launchICBM(this.name, nation);
		}else if (nation.getDevelop("탄도미사일 발사 기술")) {
			nationWithICBM = nation.name;
			hasICBM = true;
			nation.launchICBM(nation.name, this);
		}
		if(!hasICBM) {
			System.out.println("전쟁 개시!");
		}
	  
	}
}
