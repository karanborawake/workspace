package array;

import java.util.DuplicateFormatFlagsException;

public class RemoveDuplicateNumber {
	static int[] nonDuplicateSortedArray = null;
	public static void main(String[] args){
		int[] duplicateSortedAr = {1,3,7,8,8,9,14,16,16,17,17};
		nonDuplicateSortedArray = removeDuplicateMethod(duplicateSortedAr);
		
		printArray(nonDuplicateSortedArray);
	}
	
	public static void printArray(int[] array){
		
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static int[] removeDuplicateMethod(int[] array){
		int i = 0, j = 1;
		
		if(array.length < 2)
			return array;
		while(j < array.length){
			if(array[i] == array[j]){
				j++;
			}else{
				array[++i] = array[j++];
			}
		}
		nonDuplicateSortedArray = new int [i + 1 ];
		
		for (int j2 = 0; j2 < nonDuplicateSortedArray.length; j2++) {
			nonDuplicateSortedArray[j2] = array[j2];
		}
		
		return nonDuplicateSortedArray;
	}
	
}

