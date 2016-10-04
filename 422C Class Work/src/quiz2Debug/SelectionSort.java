package quiz2Debug;


public final class SelectionSort {
		
		/**
		 * Implementation of selection sort algorithm.
		 * There are 2 bugs!
		 * 
		 * @param x The integer array to sort in place
		 */
		public static void sort(int[] x) {		
			for (int i = 0; i < x.length - 1; i++) {
				 
				// Assume i is index of smallest value in array
				int min = i;
				
				//BUG!!!! smallest value in the array is will always be the last value because of the for loop statement . 
				
				// Check all other values in array to find smallest value
				for (int j = i + 1; j < x.length - 1; j++) {
					if (x[j] < x[min]) {
						min = j;
					}
				}
				
				// Swap smallest value to its correct location
				swap(x, i, min);
			}
		}
		
		/**
		 * Swap two values in place using XOR algorithm.
		 * 
		 * @param x The array of values
		 * @param a Index of first value in x
		 * @param b Index of second value in x
		 */
		private static void swap(int[] x, int a, int b) {
			//BUG!!!! Algo does not correctly sort the XOR statement and negates it too many times. 
			x[a] ^= x[b];
			x[b] ^= x[a];
			x[a] ^= x[a];
		}
}
