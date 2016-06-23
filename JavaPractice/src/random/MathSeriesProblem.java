package random;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MathSeriesProblem {
	// TODO:: Return random int number between 1 and user entered number i.e 1..100
	static int getRandomNumer(int maxLimit) {
		Random randomObj = new Random();
		int randomNumber = randomObj.nextInt(maxLimit) + 1;
		return randomNumber;
	}

	// TODO:: Get Number from user e.g. 100
	static int getNumberFromUser(){
		int inputInt = 0;
		System.out.println("Enter a number :: ");
		Scanner scannerObj = new Scanner(System.in);
		inputInt = scannerObj.nextInt();
		return inputInt;
	}

	//TODO:: Generate array of size taken from user i.e 100 
	static ArrayList<Object> genarateArrayList(int arrayListSize){
		ArrayList<Object> myArrayList = null;
		myArrayList = new ArrayList<>(arrayListSize);
		for (int i = 0; i < arrayListSize; i++) {
			myArrayList.add(i, i);
		}
		return myArrayList;
	}
	
	static int findMissingNumber(ArrayList<Object> arrayList){
		int missingNumber = -1;
		long summation = 0, totalSum = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			summation = summation + (int)arrayList.get(i);
			totalSum = totalSum + (i);
		}
		missingNumber = (int) (totalSum - summation);
		return missingNumber;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = getNumberFromUser();
		ArrayList<Object> arraylist = genarateArrayList(number);
		int randomNumber = getRandomNumer(number);
		System.out.println("Random number is :: "+ randomNumber);
		arraylist.set(randomNumber, 0);
		System.out.println("Missing number is :: "+findMissingNumber(arraylist));
		
	}
}
