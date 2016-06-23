package assignment;
import java.util.Scanner;

public class Palindrome {
	public static int reverse(int number){
		int reverseNumber = 0;
		while(number > 0){
			reverseNumber = reverseNumber * 10;
			reverseNumber = reverseNumber + number % 10;
			number = number / 10 ;
		}
		return reverseNumber;
	}
	
	public static boolean isPalindrome(int number){
		if(number == reverse(number)){
			return true;
		}
		return false;	
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter a number :: ");
		Scanner scannerObj = new Scanner(System.in);
		int number = scannerObj.nextInt();
		scannerObj.close();
		if (isPalindrome(number) == true) {
			System.out.println("Given number "+ number +" is palindrome ");
		}else{
			System.out.println("Given number "+ number +" is not palindrome ");
		}
	}
}
