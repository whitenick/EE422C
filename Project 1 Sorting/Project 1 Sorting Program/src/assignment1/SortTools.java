// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * Nicholas White
 * NWW295
 * 16465
 * Fall 2016
 */

package assignment1;

public class SortTools {
	/**
	  * This method tests to see if the given array is sorted.
	  * @param inputArray is the array
	  * @param inputIndex is the size of the input to be checked
	  * @return true if array is sorted
	  */
	
	public static boolean isSorted(int[] inputArray, int inputIndex) {
		boolean conditionBool = false;
		if (inputIndex>inputArray.length){
			return conditionBool = false;
		}
		int initial = inputArray[0];
		for (int r = 1; r<inputIndex; r++) {
			if (inputArray[r]>=initial) {
				conditionBool = true;
				initial = inputArray[r];
			}
			else {
				conditionBool = false;
			}
		}
		return conditionBool;
	}
	
	public static int find(int[] inputArray, int inputIndex, int inputValue) {
		
		for (int r = 0; r<inputIndex; r++) {
			if (inputArray[r]==inputValue){
				return r;
			}
		}
		
		return (-1);
		
	}
	
	public static int[] insertGeneral(int[] inputArray, int inputIndex, int inputValue) {
		boolean conditionBool = false; 
		int[] valueArray = new int[inputIndex];
		int[] returnArray = new int[inputIndex+1];
		for (int r = 0; r<inputIndex; r++){
			valueArray[r]=inputArray[r];
			if (inputArray[r]==inputValue){
				conditionBool = true;
}
		
		}
		if (conditionBool == true) {
			return valueArray;
		}
		else for (int r = 0; r<inputIndex+1; r++) {
				if (conditionBool==true) {
						returnArray[r]=inputArray[r-1];	
					}
				else if (r<inputIndex && inputValue<inputArray[r]) {
					returnArray[r] = inputValue;
					conditionBool = true;
				}
				
				else if (r>=inputIndex && conditionBool == false) {
					returnArray[r] = inputValue;
					}
				else {
					returnArray[r]=inputArray[r];
				}
			
		}
		return returnArray;
	}
	
	public static int insertInPlace(int[] inputArray, int inputIndex, int inputValue) {
		for (int r = 0; r<inputIndex; r++) {
			if (inputArray[r]==inputValue) {
				return inputIndex;
			}
		}
		inputArray[inputIndex] = inputValue;
		
		return inputIndex+1;
	}
	
	public static void insertSort(int[] inputArray, int inputIndex) {
		int tempVar;
		for (int k = 0; k<inputIndex; k++) {
			for (int r = k+1; r<inputIndex; r++) {
				if (inputArray[k]>inputArray[r]) {
					tempVar = inputArray[k];
					inputArray[k] = inputArray[r];
					inputArray[r] = tempVar;
				}
			}
		}
	}
	
}