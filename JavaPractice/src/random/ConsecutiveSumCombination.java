package random;

import java.util.Scanner;

public class ConsecutiveSumCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scannerObj = new Scanner(System.in);
		System.out.println("Enter a number :: ");
		int number = scannerObj.nextInt();
		sumNumber(number);

	}
	
	public static void sumNumber(int number){
		int sum = 0;
		for (int i = 0; i < number; i++) {
			sum = 0;
			for (int j = i; j < number; j++) {
				
				sum = sum + j;
				if(sum > number){
					break;
				}
				if(sum == number){
					for (int k = i; k <=j; k++) {
						
						System.out.print(k + " ");
						
					}
					System.out.println();
				}
			}
			
		}
	}

}
