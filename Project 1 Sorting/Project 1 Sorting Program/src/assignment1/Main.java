/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;
public class Main {
	public static void main(String [] args) {
		//SortTools tools = new SortTools();
		
		System.out.println("Testing isSorted Method:");
		isSortedTest1();
		isSortedTest2();
		isSortedTest3();
		isSortedTest4();
		isSortedTest5();
		isSortedTest6();
		isSortedTest7();
		
		System.out.println("Testing find Method:");
		findTest1();
		findTest2();
		findTest3();
		findTest4();
		
		System.out.println("Testing insertGeneral Method:");
		insertGeneralTest1();
		insertGeneralTest2();
		insertGeneralTest3();
		insertGeneralTest4();
		
		System.out.println("Testing insertInPlace Method:");
		insertInPlaceTest1();
		insertInPlaceTest2();
		insertInPlaceTest3();
		insertInPlaceTest4();
		
		System.out.println("Testing insertSort Method:");
		insertSortTest1();
		insertSortTest2();
		insertSortTest3();
	}
	
	
	
	/**
	 * Test Case for N < 0
	 */
	public static void isSortedTest1(){
		int[] testValues = new int[5];
		boolean testResult;
		testResult = SortTools.isSorted(testValues, -1);
		if (testResult == false){
			System.out.println("Test 1 Passed!");
		}
		else {
			System.out.println("Test 1 Failed...");
		}
	}
	
	/**
	 * Test Case for N > array length
	 */
	public static void isSortedTest2(){
		int[] testValues = new int[5];
		boolean testResult;
		testResult = SortTools.isSorted(testValues, 10);
		if (testResult == false){
			System.out.println("Test 2 Passed!");
		}
		else {
			System.out.println("Test 2 Failed...");
		}
	}
		
	/**
	 * Test Case for empty array
	 */
	public static void isSortedTest3(){
		int[] testValues = new int[5];
		boolean testResult;
		testResult = SortTools.isSorted(testValues, 5);
		if (testResult == true){
			System.out.println("Test 3 Passed!");
		}
		else {
			System.out.println("Test 3 Failed...");
		}
	}
	
	/**
	 * Checks if full array is sorted
	 */
	public static void isSortedTest4(){
		int[] testValues = {0, 1, 2, 3, 4};
		boolean testResult;
		testResult = SortTools.isSorted(testValues, 5);
		if (testResult == true){
			System.out.println("Test 4 Passed!");
		}
		else {
			System.out.println("Test 4 Failed...");
		}
	}
	
	/**
	 *Checking an unsorted array
	 */
	public static void isSortedTest5(){
		int[] testValues = {0, 5, 4, 3, 4};
		boolean testResult;
		testResult = SortTools.isSorted(testValues, 5);
		if (testResult == false){
			System.out.println("Test 5 Passed!");
		}
		else {
			System.out.println("Test 5 Failed...");
		}
	}
	
	/**
	 *Checking an partially sorted array
	 */
	public static void isSortedTest6(){
		int[] testValues = {0, 1, 4, 3, 4};
		boolean testResult;
		testResult = SortTools.isSorted(testValues, 3);
		if (testResult == true){
			System.out.println("Test 6 Passed!");
		}
		else {
			System.out.println("Test 6 Failed...");
		}
	}
	
	/**
	 *Testing Duplicate values
	 */
	public static void isSortedTest7(){
		int[] testValues = {0, 0, 1, 1, 2, 2};
		boolean testResult;
		testResult = SortTools.isSorted(testValues, 6);
		if (testResult == true){
			System.out.println("Test 7 Passed!");
		}
		else {
			System.out.println("Test 7 Failed...");
		}
	}
	
	/**
	 *Value is present test
	 */
	public static void findTest1(){
		int[] testValues = {0, 1, 2, 3, 4, 5};
		int testResult;
		testResult = SortTools.find(testValues, 6, 0);
		if (testResult == 0){
			System.out.println("Test 1 Passed!");
		}
		else {
			System.out.println("Test 1 Failed...");
		}
	}
	
	/**
	 *Value is present test
	 */
	public static void findTest2(){
		int[] testValues = {0, 1, 2, 3, 4, 5};
		int testResult;
		testResult = SortTools.find(testValues, 6, 5);
		if (testResult == 5){
			System.out.println("Test 2 Passed!");
		}
		else {
			System.out.println("Test 2 Failed...");
		}
	}
	
	/**
	 *Value is not present test
	 */
	public static void findTest3(){
		int[] testValues = {0, 1, 2, 3, 4, 5};
		int testResult;
		testResult = SortTools.find(testValues, 6, 10);
		if (testResult == -1){
			System.out.println("Test 3 Passed!");
		}
		else {
			System.out.println("Test 3 Failed...");
		}
	}
	
	/**
	 *Value is in array, but not in portion being searched
	 */
	public static void findTest4(){
		int[] testValues = {0, 1, 2, 3, 4, 5};
		int testResult;
		testResult = SortTools.find(testValues, 5, 5);
		if (testResult == -1){
			System.out.println("Test 4 Passed!");
		}
		else {
			System.out.println("Test 4 Failed...");
		}
	}

	/**
	 * v is already in array
	 */
	public static void insertGeneralTest1(){
		int[] testValues = {0, 1, 2, 3, 4};
		int[] testAnswer = {0, 1, 2, 3, 4};
		int[] testResult = new int [5];
		boolean testCheck = true;
		testResult = SortTools.insertGeneral(testValues, 5, 4);
		for (int i = 0; i < 5; i++){
			if (testResult[i] != testAnswer[i]){
				testCheck = false;
				break;
			}
		}
		if (testCheck == true){
			System.out.println("Test 1 Passed!");
		}
		else {
			System.out.println("Test 1 Failed...");
		}
	}
	
	/**
	 * v is not in array, inserting onto end
	 */
	public static void insertGeneralTest2(){
		int[] testValues = {0, 1, 2, 3, 4};
		int[] testAnswer = {0, 1, 2, 3, 4, 5};
		int[] testResult = new int [6];
		boolean testCheck = true;
		testResult = SortTools.insertGeneral(testValues, 5, 5);
		for (int i = 0; i < 5; i++){
			if (testResult[i] != testAnswer[i]){
				testCheck = false;
				break;
			}
		}
		if (testCheck == true){
			System.out.println("Test 2 Passed!");
		}
		else {
			System.out.println("Test 2 Failed...");
		}
	}
	
	/**
	 * v is not in array, inserting into middle
	 */
	public static void insertGeneralTest3(){
		int[] testValues = {0, 1, 3, 4, 5};
		int[] testAnswer = {0, 1, 2, 3, 4, 5};
		int[] testResult = new int [6];
		boolean testCheck = true;
		testResult = SortTools.insertGeneral(testValues, 5, 2);
		for (int i = 0; i < 5; i++){
			if (testResult[i] != testAnswer[i]){
				testCheck = false;
				break;
			}
		}
		if (testCheck == true){
			System.out.println("Test 3 Passed!");
		}
		else {
			System.out.println("Test 3 Failed...");
		}
	}
	
	/**
	 * v is not in array, inserting into middle, only use part of original array
	 */
	public static void insertGeneralTest4(){
		int[] testValues = {0, 1, 3, 4, 5};
		int[] testAnswer = {0, 1, 2, 3, 4};
		int[] testResult = new int [5];
		boolean testCheck = true;
		testResult = SortTools.insertGeneral(testValues, 4, 2);
		for (int i = 0; i < 5; i++){
			if (testResult[i] != testAnswer[i]){
				testCheck = false;
				break;
			}
		}
		if (testCheck == true){
			System.out.println("Test 4 Passed!");
		}
		else {
			System.out.println("Test 4 Failed...");
		}
	}

	/**
	 * v is already in array
	 */
	public static void insertInPlaceTest1(){
		int[] testValues = {0, 1, 2, 3, 4};
		int testResult;
		testResult = SortTools.insertInPlace(testValues, 5, 4);
		if (testResult == 5){
			System.out.println("Test 1 Passed!");
		}
		else {
			System.out.println("Test 1 Failed...");
		}
	}
	
	/**
	 * v is already in array, partially checking of array
	 */
	public static void insertInPlaceTest2(){
		int[] testValues = {0, 1, 2, 3, 4};
		int testResult;
		testResult = SortTools.insertInPlace(testValues, 4, 2);
		if (testResult == 4){
			System.out.println("Test 2 Passed!");
		}
		else {
			System.out.println("Test 2 Failed...");
		}
	}
	
	/**
	 * v is not already in array, partially checking of array
	 */
	public static void insertInPlaceTest3(){
		int[] testValues = {0, 1, 3, 4};
		int testResult;
		testResult = SortTools.insertInPlace(testValues, 3, 2);
		if (testResult == 4){
			System.out.println("Test 3 Passed!");
		}
		else {
			System.out.println("Test 3 Failed...");
		}
	}
	
	/**
	 * v is not already in array, partially checking of array
	 */
	public static void insertInPlaceTest4(){
		int[] testValues = {0, 2, 3, 4};
		int testResult;
		testResult = SortTools.insertInPlace(testValues, 3, 1);
		if (testResult == 4){
			System.out.println("Test 4 Passed!");
		}
		else {
			System.out.println("Test 4 Failed...");
		}
	}
	
	/**
	 * 2 term test
	 */
	public static void insertSortTest1(){
		int[] testArray = {1, 0};
		int[] testAnswer = {0, 1};
		boolean testCheck = true;
		SortTools.insertSort(testArray, 2);
		for (int i = 0; i < 2; i++){
			if (testArray[i] != testAnswer[i]){
				testCheck = false;
				break;
			}
		}
		if (testCheck == true){
			System.out.println("Test 1 Passed!");
		}
		else {
			System.out.println("Test 1 Failed...");
		}
	}
	
	/**
	 * duplicates of same number with sorting
	 */
	public static void insertSortTest2(){
		int[] testArray = {1, 1, 0};
		int[] testAnswer = {0, 1, 1};
		boolean testCheck = true;
		SortTools.insertSort(testArray, 3);
		for (int i = 0; i < 3; i++){
			if (testArray[i] != testAnswer[i]){
				testCheck = false;
				break;
			}
		}
		if (testCheck == true){
			System.out.println("Test 2 Passed!");
		}
		else {
			System.out.println("Test 2 Failed...");
		}
	}
	
	/**
	 * duplicates of same number with sorting- longer
	 */
	public static void insertSortTest3(){
		int[] testArray = {10, 5, 5, 3, 3, 6, 7};
		int[] testAnswer = {3, 3, 5, 5, 6, 7, 10};
		boolean testCheck = true;
		SortTools.insertSort(testArray, 7);
		for (int i = 0; i < 7; i++){
			if (testArray[i] != testAnswer[i]){
				testCheck = false;
				break;
			}
		}
		if (testCheck == true){
			System.out.println("Test 3 Passed!");
		}
		else {
			System.out.println("Test 3 Failed...");
		}
	}
}




