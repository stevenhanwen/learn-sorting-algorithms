import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        // testBubbleSortSmallData();

        //testBubbleSortLargeData();

        // testMergeSortedArray();

        // testMergeSortSmallData();

        testSortLargeData();

        // testIsArraySortedSmallData();

        // testSelectionSortSmallData(); 

        // testInsertionSortSmallData(); 

    }


    public static void testInsertionSortSmallData(){

        int[] arrayTest = {30, 15, 4, 9, 6, 10, 8};
        //System.out.Println(“Array is sorted? ” + isArraySorted(arrayTest))
        Sorting.insertionSort(arrayTest);
        System.out.println("After selection sort:");
        printArray(arrayTest);

        if (isArraySorted(arrayTest)){
            System.out.println("array is sorted");
        }  else {
            System.out.println("error, not sorted");
        }

        int[] array0 = {};
        Sorting.insertionSort(array0);

        if (isArraySorted(array0)){
            System.out.println("array is sorted");
        }  else {
            System.out.println("error, not sorted");
        }
    
        int[] array1 = {2};
        Sorting.insertionSort(array1);

        if (isArraySorted(array1)){
            System.out.println("array is sorted");
        }  else {
            System.out.println("error, not sorted");
        }
    
        int[] array2 = {2, 2, 2, 6, 6, 6, 1};
        Sorting.insertionSort(array2);

        if (isArraySorted(array2)){
            System.out.println("array is sorted");
        }  else {
            System.out.println("error, not sorted");
        }
        

    }

    public static void testSelectionSortSmallData(){

        int[] arrayTest = {30, 15, 4, 9, 6, 10, 8};
        //System.out.Println(“Array is sorted? ” + isArraySorted(arrayTest))
        Sorting.selectionSort(arrayTest);
        System.out.println("After selection sort:");
        printArray(arrayTest);

        if (isArraySorted(arrayTest)){
            System.out.println("array is sorted");
        }  else {
            System.out.println("error, not sorted");
        }

        int[] array0 = {};
        Sorting.selectionSort(array0);

        if (isArraySorted(array0)){
            System.out.println("array is sorted");
        }  else {
            System.out.println("error, not sorted");
        }
    
        int[] array1 = {2};
        Sorting.selectionSort(array1);

        if (isArraySorted(array1)){
            System.out.println("array is sorted");
        }  else {
            System.out.println("error, not sorted");
        }
    
        int[] array2 = {2, 2, 2, 6, 6, 6, 1};
        Sorting.selectionSort(array2);

        if (isArraySorted(array2)){
            System.out.println("array is sorted");
        }  else {
            System.out.println("error, not sorted");
        }
        

    }

    public static void testIsArraySortedSmallData() {
        int[] array1 = {};
        System.out.println("the array with no values is sorted: " + isArraySorted(array1));

        int[] array2 = {5};
        System.out.println("the array with one value is sorted: " + isArraySorted(array2));
    }

    // isArraySorted returns if an array is sorted
    public static boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] > array[i+1]){
                return false;
            }
        }
        return true; 
    }
    
        // testBubbleSortLargeData sorts the large data using bubblesort.
        public static void testSortLargeData() {

            String prefix = "/Users/stevenkang/Documents/code/learn-sorting-algorithms/testdata/";
	        String[] filenames = {prefix+"2k.dat", prefix+"4k.dat", prefix+"6k.dat", prefix+"8k.dat", prefix+"10k.dat"};
            int j = 2;
	        for (int i=0; i < filenames.length; i++) {
                String filename = filenames[i];
                int[] array = getIntegerArrayFromFile(filename);
                long start = System.nanoTime();
                //mergeSort(array);
                // bubbleSort(array);
                // Sorting.selectionSort(array);
                mergeSortRecursive(array);
                //Sorting.insertionSort(array);
                long finish = System.nanoTime();
                long timeElapsed = finish - start;
                System.out.println("Merge sorting " + j + "k data strand runtime: " + timeElapsed/1000 + " microseconds");
                System.out.println("the array is sorted: " + isArraySorted(array));
                j = j + 2;
            }
            

            // int[] array1k = getIntegerArrayFromFile("/Users/stevenkang/Documents/code/learn-sorting-algorithms/testdata/1k.dat");
            // long start = System.nanoTime();
            // mergeSort(array1k);
            // long finish = System.nanoTime();
            // long timeElapsed = finish - start;
            // System.out.println("Merge sorting 1k data strand runtime: " + timeElapsed/1000 + " microseconds");
            // System.out.println("the array is sorted: " + isArraySorted(array1k));
            
            // //System.out.println("sorted");
            // //printArray(array1k);
    
            // int[] array5k = getIntegerArrayFromFile("/Users/stevenkang/Documents/code/learn-sorting-algorithms/testdata/5k.dat");
            // start = System.nanoTime();
            // mergeSort(array5k);
            // finish = System.nanoTime();
            // timeElapsed = finish - start;
            // System.out.println("Merge sorting 5k data strand runtime: " + timeElapsed/1000 + " microseconds");
            // System.out.println("the array is sorted: " + isArraySorted(array5k));
    
            //System.out.println("sorted");
            //printArray(array5k);
        }
    
    public static void testMergeSortSmallData() {
        int[] arrayTest = {30, 15, 4, 9, 6, 10, 8};
        //System.out.Println(“Array is sorted? ” + isArraySorted(arrayTest))
        mergeSort(arrayTest);
        System.out.println("After merge sort:");
        printArray(arrayTest);
        //System.out.Println("After merge sort, array is sorted?  + isArraySorted(arrayTest))
    
        // copy more test cases from testBubbleSortSmallData
        // make sure the results look good

        int[] array0 = {};
        mergeSort(array0);
        printArray(array0);
    
        int[] array1 = {2};
        mergeSort(array1);
        printArray(array1);
    
        int[] array2 = {2, 2, 2, 6, 6, 6, 1};
        mergeSort(array2);
        printArray(array2);
    }


    public static void mergeSortRecursive(int[] array){
        sortArray(0, array.length - 1, array);
    }

    private static void sortArray(int low, int high, int[] array){
        if (high - low >= 1){
            int leftEnd = (low + high) / 2;
            int rightStart = leftEnd + 1; 

            sortArray(low, leftEnd, array);
            sortArray(rightStart, high, array);

            mergeSortedArray (array, low, leftEnd, rightStart, high);
        }
    }
    
    // Iteration approach
    public static void mergeSort(int[] array) {
        // implement mergeSort
        int groupSize = 1;
        double numberOfGroups;
        int numberOfPairs;
        int leftStart;
        int rightStart;
        int rightEnd; 
        int leftEnd;
        for (; groupSize < array.length; groupSize = groupSize * 2){
            numberOfGroups = Math.ceil(array.length/groupSize);
            numberOfPairs = (int) Math.ceil(numberOfGroups/2);

            //System.out.println("groupsize: " + groupSize + " number of groups: " + numberOfGroups + " number of pair: " + numberOfPairs);
            // this for-loop divides the array into pairs—leftarray rightarray
            // and merges the left array with the right array. 
            for (int pairIndx = 0; pairIndx < numberOfPairs; pairIndx++) {
                leftStart = pairIndx * groupSize * 2; 
                leftEnd = leftStart + groupSize - 1; 
                rightStart = leftStart + groupSize; 
                rightEnd = leftStart + 2 * groupSize - 1; 

                // if the right array has one element, 
                // we are reaching the end of the 
                // array, so break the inner for-loop. 
                if (rightStart >= array.length){
                    break; 
                }

                // if the right array is less than 
                // the groupSize, set the rightEnd
                // to the last element of the array. 
                if (rightEnd >= array.length){
                    rightEnd = array.length - 1; 
                }

                mergeSortedArray(array, leftStart, leftEnd, rightStart, rightEnd);
            }
        }
    }
    

    public static void testMergeSortedArray() {
        int[] array = {30, 15, 4, 9, 6, 10, 8};
        // test from group size = 1
        mergeSortedArray(array, 0, 0, 1, 1);     // merge (30)  and (15)
        System.out.print("1: Partially sorted array ");    // make sure only 30, 15 are sorted
        printArray(array);
  
        mergeSortedArray(array, 2, 2, 3, 3) ;    // merge (4)  and (9)
        System.out.print("2: Partially sorted array ");    // make sure only 4, 9 are sorted
        printArray(array);
  
        mergeSortedArray(array, 4, 4, 5, 5);     // merge (6)  and (10)
        System.out.print("3: Partially sorted array " );    // make sure only 4, 9 are sorted
        printArray(array);
  
        // Now we test group size = 2
        mergeSortedArray(array, 0, 1, 2, 3);     // merge (15, 30)  and (4, 9)
        System.out.print("4: Partially sorted array ");   // ensure only30, 15, 4, 9 are sorted
        printArray(array);
  
        mergeSortedArray(array, 4, 5, 6, 6);     // merge (6, 10)  and (8)
        System.out.print("5: Partially sorted array ");  // ensure only 6, 10, 8 are sorted
        printArray(array);
  
        mergeSortedArray(array, 0, 3, 4, 6); 
        System.out.print("6: sorted array ");
        printArray(array);
        // Now we test group size = 4
        // Can you write this one? After this step, is the array sorted?
  
        // Do we need to test group size = 8? no
  }
  
  
  // mergeSortedArray merges and sorts two groups
    public static void mergeSortedArray (int[] array, int leftStart, int leftEnd, int rightStart, int rightEnd) {
  
        // Make copies of left and right array
        int[] leftArray = new int[leftEnd - leftStart + 1];
        int[] rightArray = new int[rightEnd - rightStart + 1];

        // copy integers to leftArray
        int j = 0;
        for (int i = leftStart; i <= leftEnd; i++ ){
            leftArray[j] = array[i];
            j++;
        }

        // copy integers to rightArray
        j = 0;
        for (int i = rightStart; i <= rightEnd; i++ ){
            rightArray[j] = array[i];
            j++;
        }

        // assigns the smaller integer to the original array
        // from left copy and right copy
        int k = leftStart;     
        int i = 0; 
        j = 0; 
        for (;i < leftArray.length && j < rightArray.length;) {
            if (leftArray[i] < rightArray[j]){
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // assigns remaining values from left array
        for (;i < leftArray.length; i++){
            array[k] = leftArray[i];
            k++;
        }

          // assigns remaining values from right array
          for (;j < rightArray.length; j++){
            array[k] = rightArray[j];
            k++;
        }
  }
  

    // bubblesort sorts the int array using bubblesort.
    public static void bubbleSort(int [] array) {
        int n = array.length; 
        //outer for-loop controls number of passes n-1
        for (int i = 0; i < n -1 ; i++){
            
            //inner loop is the pass over the array
            for (int j = 0; j + 1 < n - i; j++){
                //swap if out of order
                if (array[j] > array[j+1]){
                    int temp = array[j]; 
                    array[j] = array[j+1];
                    array[j+1] = temp; 
                
                }
            }
        }
    }    

    // testBubbleSortLargeData sorts the large data using bubblesort.
    public static void testBubbleSortLargeData() {
        int[] array1k = getIntegerArrayFromFile("/Users/stevenkang/Documents/code/learn-sorting-algorithms/testdata/1k.dat");
        long start = System.nanoTime();
        bubbleSort (array1k);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Bubble sorting 1k data strand runtime: " + timeElapsed/1000 + " microseconds");
        
        //System.out.println("sorted");
        //printArray(array1k);

        int[] array5k = getIntegerArrayFromFile("/Users/stevenkang/Documents/code/learn-sorting-algorithms/testdata/5k.dat");
        start = System.nanoTime();
        bubbleSort (array5k);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Bubble sorting 5k data strand runtime: " + timeElapsed/1000 + " microseconds");

        //System.out.println("sorted");
        //printArray(array5k);
    }
    
    // getIntegerArrayFromFile takes a filename and returns an integer array. 
    static int[] getIntegerArrayFromFile(String filename) {
        String str = readUsingBufferedReader(filename);
        String[] splitArray = str.split(",");
        int[] array = new int[splitArray.length];
 
        // parsing the String argument as a signed decimal
        // integer object and storing that integer into the
        // array
        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }

    // readUsingBufferedReader takes filename and returns the content as a String. 
    private static String readUsingBufferedReader(String fileName) {
		BufferedReader reader = null;
		StringBuilder stringBuilder = new StringBuilder();

		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = null;
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			// delete the last ls
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return stringBuilder.toString();
	}

    // testBubbleSortSmallData tests the bubbleSort method using small size data. 
    public static void testBubbleSortSmallData() {
        int[] array = {5, 4, 1, 2, 3};
        bubbleSort(array);
        printArray(array);
    
        int[] array0 = {};
        bubbleSort (array0);
        printArray(array0);
    
        int[] array1 = {2};
        bubbleSort(array1);
        printArray(array1);
    
        int[] array2 = {2, 2, 2, 6, 6, 6, 1};
        bubbleSort(array2);
        printArray(array2);
    }

    // printArray prints the int array. 
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
}