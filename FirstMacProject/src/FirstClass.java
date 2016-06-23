import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		int[] array = new int[5];
		System.out.println("Please enter an array of "+ array.length);
		for (int i = 0; i < array.length; i++) {
			array[i] = obj.nextInt();
		}
		printArray(array);
		
		selectionSort(array);
		System.out.println();
		printArray(array);
		System.out.println();
		bubbleSort(array);
		System.out.println();
		printArray(array);
	}
	public static void printArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(+ arr[i] + " ");
		}
	}
	
	public static void selectionSort(int[] array){
		int iMin = 0;
		for (int i = 0; i < array.length; i++) {
			iMin = i ;
			for (int j = i; j < array.length; j++) {
				if(array[iMin] > array[j] ){
					iMin = j;
				}
			}
			int temp = array[iMin];
			array[iMin] = array[i];
			array[i] = temp;
		}
	}
	
	public static void bubbleSort(int[] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if(array[j-1] > array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	
	
}
