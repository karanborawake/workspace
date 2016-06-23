package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Given an array of integers, sort the integer values.
		 * */
		int[] num = new int[] {9, 8 ,7 ,6 , 5};
		System.out.println("Array before bubble sort:: ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		bubbleSort1(num);
		System.out.println("Array after bubble sort:: ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();

	}
	
	public static void bubbleSort1(int[] num){
		
		for(int i = 0 ; i<num.length; i++){
			for (int j = 1; j < (num.length-i); j++) {
	            int temp = 0;
	            if (num[j-1] > num[j]) {
	                temp = num[j-1];
	                num[j-1] = num[j];
	                num[j] = temp;
	            }
	        	
	        }
			
		}
		
	}
}
