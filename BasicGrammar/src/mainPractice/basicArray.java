package mainPractice;
import java.util.Scanner;


public class basicArray {
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5};
		
		System.out.println(intArr);
		
		for(int i = 0; i<intArr.length; i++) {
			if (i == intArr.length-1) {
				System.out.printf("%d \n",intArr[i]);	
			}else {
				System.out.printf("%d ",intArr[i]);	
			}
			
		}
		
		String[] wordSet = new String[5];
		wordSet[0] = "hello";
		wordSet[1] = "world";
		wordSet[2] = "GoodBye";
		
		for(int j = 0; j<wordSet.length; j++) {
			System.out.printf("%s ", wordSet[j]);
		}
		
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		
		int inputCnt = scan.nextInt();
		
		for(int j = 0; j<=inputCnt; j++) {
			int num = scan2.nextInt();
			System.out.println(num);
		}
		
		scan.close();
		scan2.close();
	
	}
}
