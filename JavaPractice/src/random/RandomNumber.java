package random;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Random numbers are :: ");
		Random obj = new Random();
		for (int i = 0; i <= 10; i++) {
			int n = obj.nextInt(50);
			//int value = (int) (Math.random());
			System.out.print(n +" ");
		}
		
	}

}
