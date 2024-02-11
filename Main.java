public class Main {
    public static void main(String[] args) throws Exception {
        testBubbleSortSmallData();
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