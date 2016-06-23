package random;	

/*	OUTPUT::
 * 	Enter a number 1 : 336
	Enter a number 2 : 224
	LCM of 336 and 224 is ::672
 * 
 * */

import java.util.Scanner;

public class LCMProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lcm = 0;
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a number 1 : ");
		int a = reader.nextInt();
		System.out.print("Enter a number 2 : ");
		int b = reader.nextInt();
		for(int i = 1; i<= (a * b); i++){
			if(i % a == 0 && i % b == 0){
				lcm = i;
				break;
			}
		}
		System.out.println("LCM of "+a + " and " +b +  " is ::" +lcm);
	}
}


