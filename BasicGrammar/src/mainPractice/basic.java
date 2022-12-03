package mainPractice;
import java.util.Scanner;

public class basic {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int limit = scan.nextInt();
		
		double cnt = 0;
		
		for (int i = 0; i<=limit; i+=2) {
			cnt += 1;
			System.out.printf("%d까지의 %d값 \n", limit, i);
		}
		
		
		Scanner scan2 = new Scanner(System.in);
		
		String word = scan2.nextLine();
		scan.close();
		scan2.close();
		
		printString(word);
	}
	
	public static void printString(String word) {
		System.out.println(word);
	}
	
	
}
