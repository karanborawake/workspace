package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{ 2 , 5 , 1 , 4 , 6};
		int[] B = selectionSortMethod( A );
		System.out.println("Sorted array using selection sort::");
		for (int i = 0; i < B.length; i++) {
			System.out.print( B[i] +" ");
		}
	}

	public static int[] selectionSortMethod(int[] array){
		int iMin = 0;
		for (int i = 0; i < array.length-1; i++) {
			iMin = i;
			for (int j = i+1; j < array.length; j++) {
				if(array[iMin] > array[j])
					iMin = j;
			}
			int smallerNumber = array[iMin];
			array[iMin] = array[i];
			array[i] = smallerNumber;
		}
		return array;
	}
}
