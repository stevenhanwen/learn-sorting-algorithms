import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        //testBubbleSortSmallData();

        testBubbleSortLargeData();
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
        System.out.println("Sorting 1k data strand runtime: " + timeElapsed/1000000 + " milliseconds");
        
        //System.out.println("sorted");
        //printArray(array1k);

        int[] array5k = getIntegerArrayFromFile("/Users/stevenkang/Documents/code/learn-sorting-algorithms/testdata/5k.dat");
        start = System.nanoTime();
        bubbleSort (array5k);
        finish = System.nanoTime();
        timeElapsed = finish - start;
        System.out.println("Sorting 5k data strand runtime: " + timeElapsed/1000000 + " milliseconds");

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