package array;

/*public class MaxTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1 , 5 ,7 ,4 ,8 , 9};
		printTwoMaxNumbers(num);
	}

	public static void printTwoMaxNumbers(int[] array){
		int maxOne = array[0], maxTwo = array[0];
		for (int i = 1; i < array.length; i++) {
			if(array[i] > array[maxOne]){
				array[maxTwo] = array[maxOne];
				array[maxOne] = array[i];
			}else if(array[i] > array[maxTwo]){
				array[maxTwo] = array[i];
			}

		}
		System.out.println(maxOne);
		System.out.println(maxTwo);
	}

}*/

public class TwoMaxNumbers {
	
	//method of finding maximum two array using for each loop
	public void printTwoMaxNumbers(int[] nums){
		int maxOne = 0;
		int maxTwo = 0;
		for(int n:nums){
			if(maxOne < n){
				maxTwo = maxOne;
				maxOne =n;
			} else if(maxTwo < n){
				maxTwo = n;
			}}
		System.out.println("First Max Number: "+maxOne);
		System.out.println("Second Max Number: "+maxTwo);
	}
	
	
	//print array
	public void printArray(int[] num){
		for (int i : num) {
			System.out.print(i+" ");
		}
	}
	
	//method of finding maximum two array using normal for loop
	public static void maxTwo(int[] array){
		int maxOne = 0, maxTwo = 0;
		for (int i = 1; i < array.length; i++) {
			if(maxOne < array[i]){
				maxTwo = maxOne;
				maxOne = array[i];
			}else if(maxTwo < array[i]){
				maxTwo = array[i];
			}
		}
		System.out.println(maxOne);
		System.out.println(maxTwo);
	}
	
	//main method
	public static void main(String a[]){
		int num[] = {5,34,78,2,45,1,99,23};
		TwoMaxNumbers tmn = new TwoMaxNumbers();
		tmn.printTwoMaxNumbers(num);
		tmn.printArray(num);
		System.out.println();
		maxTwo(num);
	}
}
