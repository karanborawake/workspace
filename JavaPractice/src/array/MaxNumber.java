package array;

public class MaxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2 , 5 , 7 , 5 , 11};
		
		int max = array[0];
		
		for (int i = 1; i < array.length; i++) {
			
			if(array[i] > max){
				max = array[i];
			}
		}
		
		System.out.println(max);
		
	}

}
