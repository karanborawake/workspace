package assignment;
import java.util.Scanner;

public class AverageScore {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter scores :: ");
		Scanner scannerObj = new Scanner(System.in);
		int[] array = new int[100];
		int i = 0, sum = 0;
		do{
			array[i] = scannerObj.nextInt();
			i++;
		}while(array[i-1] > 0 && i < 100);
		scannerObj.close();
		
		for (int j = 0; j < i-1 ; j++) {
			sum += array[j];
		}
		int average = sum / i;
		int aboveOrEqual = 0, belowAvg = 0;
		for (int j = 0; j < i-1 ; j++) {
			if(array[j] >= average)
				aboveOrEqual++;
			else
				belowAvg++;
		}
		System.out.println("scores average :: " + average);
		System.out.println("score above or equal to the average :: " + aboveOrEqual ); 
		System.out.println("scores below average :: " + belowAvg);	
	}
}
