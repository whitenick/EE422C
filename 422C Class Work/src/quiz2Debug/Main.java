package quiz2Debug;

public class Main {
	public static void main(String[] args){
		int[] x = {4, 6, 8, 3};
		SelectionSort.sort(x);
		int initial = x[0];
		boolean conditionBool = true; 
		for(int i=0; i<x.length; i++){
			if (initial > x[i]){
				conditionBool = false; 
		}
		
		//If condition results in false, then algorithim did not replace x[0] with smallest value in array
		System.out.println("Boolean condition: ");
		System.out.println(conditionBool);
	}
}
}
