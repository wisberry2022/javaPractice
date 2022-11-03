package mainPractice;
import java.util.ArrayList;
import java.util.Scanner;

public class basicArrayList {
	public static void main(String[] args) {
		ArrayList<String> wordSet = new ArrayList<>();
		ArrayList<Integer> intSet = new ArrayList<>();
		
		System.out.println(wordSet);
		wordSet.add("hello");
		wordSet.add("World");
		System.out.println(wordSet);
		
		Scanner scan = new Scanner(System.in);
		int userInt = scan.nextInt();
		
		for(int i = 0; i<userInt; i++) {
			intSet.add(i);
		}
		
		System.out.println(intSet);
		System.out.println(wordSet.get(1));
		
		// get - ArrayList의 값을 리턴함과 동시에 원본 배열에도 이상없음
		String word = wordSet.get(1);
		
		// size - ArrayList의 개수를 리턴한다.
		System.out.println(wordSet.size());
		
		// contains - ArrayList 내부에 해당 객체 있는지 확인
		System.out.println(wordSet.contains("hello"));
		
		// remove - ArrayList 원소 삭제 후 결과를 불리언 값으로 리턴
		System.out.println(wordSet.remove(0));
		System.out.println(wordSet);
		scan.close();	
	}
}
