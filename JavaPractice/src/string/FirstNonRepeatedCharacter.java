package string;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a string :: ");
		Scanner scannerObj = new Scanner(System.in);
		String stringObj = scannerObj.nextLine();
		
		char key = firstNonrepeated(stringObj);
		System.out.println(key);
		

	}
	
	public static Character firstNonrepeated(String str1){
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		char c ;
		for (int i = 0; i < str1.length(); i++) {
			c = str1.charAt(i);
			if(hash.containsKey(c)){
				hash.put(c, hash.get(c)+1);
			}else{
				hash.put(c, 1);
			}
		}
		for (int i = 0; i < str1.length(); i++) {
			c = str1.charAt(i);
			if(hash.get(c) == 1){
				return c;
			}
		}
		return null;
	}

}
