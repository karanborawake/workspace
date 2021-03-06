package recursion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factWithoutRecursion(4);
		int fact = factRecursion(5);
		System.out.println(fact);
	}
	
	//without recursion
	public static void factWithoutRecursion(int number){
		
		int fact = 1 ;
		
		for (int i = 1; i <= number; i++) {
			fact = fact * i ;
		}
		System.out.println(fact);
	}
	
	//with recursion
	public static int factRecursion(int number){
		if(number ==0){
			return 1;
		}else{
			return number * factRecursion(number-1);
		}
	}

}
