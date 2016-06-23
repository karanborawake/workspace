package collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class HashMapFromFile {

	public static void main(String[] args) {
		String file = "/Users/sonali/workspace/JavaPractice/src/collection/input.txt";
		// TODO Auto-generated method stub
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			Map <String, Integer> MyHashMap = new HashMap<String, Integer>();
			String line;
			String[] token = null;
			while ((line = br.readLine()) != null) {
				line = line.replace("\n", "").replace("\r", "");
				System.out.println("Read line :: " + line);
				token = line.split(",");
				for(int i = 0; i < token.length; i++){
					System.out.println(token.length + ":::::" + i);
					token[i] = token[i].trim();
					String[] pair = null;
					pair = token[i].split("-");
					String key = pair[0];
					System.out.println(pair[1].trim().length());
					Integer value = Integer.parseInt(pair[1].trim());
					MyHashMap.put(key, value);
					System.out.println("Key :: " + pair[0] + "Value :: " + pair[1]);
				}
			}

			br.close();
			for (String i : MyHashMap.keySet()) {
				System.out.println(i +" : "+ MyHashMap.get(i));
			}
		}
		catch(Exception e){
			System.out.println("ERROR :: " + e);
		}

	}

}
