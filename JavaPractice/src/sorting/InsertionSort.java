 package sorting;

public class InsertionSort {
	 public static void main(String[] args) {
         
	        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
	        insertionSort(input);
	    }
	     
	    private static void printNumbers(int[] input) {
	         
	        for (int i = 0; i < input.length; i++) {
	            System.out.print(input[i] + " ");
	        }
	        System.out.println("\n");
	    }
	 
	    public static void insertionSort(int array[]) {
	        int n = array.length;
	        for (int i = 1; i < n; i++) {
	            int key = array[i];
	            int j = i-1;
	            while ( (j > -1) && ( array [j] > key ) ) {
	                array [j+1] = array [j];
	                j--;
	            }
	            array[j+1] = key;
	            
	        }
	        printNumbers(array);
	    }
}
