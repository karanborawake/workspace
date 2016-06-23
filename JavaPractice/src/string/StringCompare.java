package string;

public class StringCompare {

	public static void main(String[] args){
		String str1 = "Sonali";
		String str2 = new String("Sonali");
		//String equals
		if(str1.equals(str2)){
			System.out.println(str1 +" is equals to " + str2 );
		}else{
			System.out.println(str1 +" is not equals to " + str2 );
		}
		stringReverse("sonali");
	}
	
	public static void stringReverse(String input){
		String output = "";
		for (int i = input.length()-1; i >=0; i--) {
			output = output + input.charAt(i);
		}
		System.out.println(output);
	}

}
