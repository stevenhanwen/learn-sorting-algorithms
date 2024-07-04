public class Sorting {
    
    public static void selectionSort(int[] input){
        int smallest; // index of smallest value
        for (int i = 0; i < input.length; i++){
            smallest = i; 
            // i is the index of the remaining array
            for (int j = i + 1; j < input.length; j++){
                if (input[j] < input [smallest]){
                    smallest = j; 
                }
            }

            int temp = input [i]; 
            input [i] = input [smallest]; 
            input [smallest] = temp; 

        }
    }

}
