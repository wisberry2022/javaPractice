package mainPractice;
import java.util.Scanner;

public class basic02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		
		
		testString(removeSpace(str));
		
		scan.close();
		
		
	}
	
	public static String[] removeSpace(String words) {
		String[] wordSet = words.split(" ");
		return wordSet;
	}
	
	public static void testString(String... Strings) {
		for (int i = 0; i<Strings.length; i++) {
			System.out.println(Strings[i]);
		}
	}
}
