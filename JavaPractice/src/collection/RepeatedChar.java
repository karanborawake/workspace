package collection;

import java.util.HashMap;
import java.util.Map;

public class RepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("Karan");
		Map<Character, Integer> myMap = new HashMap<Character,Integer>();
		
		for (int i = 0 ;i < str.length(); i++) {
			if(myMap.containsKey(str.charAt(i)))
			{
				myMap.put(str.charAt(i), 1 + myMap.get(str.charAt(i)));
			}
			else{
				myMap.put(str.charAt(i), 1);	
			}
			
			for (Map m : myMap) {
				
			}
			
			//System.out.println(array[i]);
		}

	}

}