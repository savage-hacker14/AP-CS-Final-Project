
public class SortArray {
	public static void main(String[] args) {
		SortArray myClass = new SortArray();
		
		 int[] a = {2,4,3,1};
		//int[] a = {4,2};
		int[] sortedA = myClass.sortArray(a);
		printArray(a);
		printArray(sortedA);
	}
	
	// Pseudo Code:
	// Method that sorts, returns array
	// 		1. Grab and store first element 
	//		2. Sort remainder of array (call sort array recursively, elements 1-(N-1)
	//		3. Insert stored element into the sorted array in the correct place and return array of length n
	//		NOTE (Base Case): If N = 1, just return array (already sorted)
	
	public int[] sortArray(int[] inArray) {
		printArray(inArray);

		int N = inArray.length;
		int[] outputArray = new int[N];
		
		//		NOTE (Base Case): If N = 1, just return array (already sorted)
		if (inArray.length == 1) {		// Base case / trivial case 
			outputArray[0] = inArray[0];
			return outputArray;
		}
		
		// 		1. Grab and store first element 
		int firstElement = inArray[0];
		
		//		2. Sort remainder of array (call sort array recursively, elements 1-(N-1)
		int[] remainderArray = new int[N - 1];
		
		for (int i = 1; i < N; i++) {
			remainderArray[i - 1] = inArray[i];
		}
		
		int[] sortedRemainderArray = new int[N - 1];
		sortedRemainderArray = sortArray(remainderArray);
		// Continues calling until base case is reached
		
		
		//		3. Insert stored element into the sorted array in the correct place and return array of length n
//		int[] outputArray = new int[N];
		int insertionPoint = 0;
		boolean firstElementInserted = false;
		int insertElement = 99;
		
		for (int i = 0; i < N - 1; i++) {
			if (firstElement < sortedRemainderArray[i] && !firstElementInserted) {
				// Insert 1st element
				outputArray[insertionPoint] = firstElement;
				System.out.print("firstElement =");
				System.out.println(firstElement);
				
				firstElementInserted = true;
				i--;
			}
			
			else {
				//outputArray[insertionPoint] = sortedRemainderArray[i];
				insertElement = sortedRemainderArray[i];
				System.out.print("insertElement =");
				System.out.println(insertElement);
				outputArray[insertionPoint] = insertElement;
				
				//outputArray[insertionPoint] = remainderArray[i];
			
			}
			

			System.out.print("insertionPoint =");
			System.out.println(insertionPoint);
			insertionPoint++;

		}
		// add firstElement at the end if needed
		if (!firstElementInserted) {
			outputArray[insertionPoint] = firstElement;
		}
		
		printArray(sortedRemainderArray);
		printArray(outputArray);
		return outputArray;
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
}
