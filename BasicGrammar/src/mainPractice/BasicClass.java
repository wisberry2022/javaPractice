package mainPractice;
import models.Nation;

public class BasicClass {
	public static void main(String[] args) {
		System.out.println("실행!");
		
		Nation Unknown = new Nation();
		
		Nation Korea = new Nation("대한민국", 5000, "서울");
		Nation NorthKorea = new Nation("북한", 2000, "평양");
		Unknown.getNation();
		NorthKorea.developTech("탄도미사일 발사 기술");
		NorthKorea.getNation();
		Korea.developTech("제철기술");
		Korea.developTech("컴퓨터 과학기술");
		Korea.getNation();
		
		NorthKorea.war(Korea);
	}
	
}
