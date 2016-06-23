package assignment;
import java.util.Scanner;

public class PrintReverseArray {
	public static void printArray(int[] array){
		System.out.print("Reverse order is :: ");
		for (int i = array.length-1; i >= 0 ; i--) {
			System.out.print(array[i] +" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter 10 number :: ");
		Scanner scannerObj = new Scanner(System.in);
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = scannerObj.nextInt();
		}
		scannerObj.close();
		printArray(array);
	}
}
