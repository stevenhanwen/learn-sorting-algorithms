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

    public static void insertionSort(int[] input){
        int insert; //temp variable
        for (int i = 1; i < input.length; i++){
            insert = input[i]; 
            int movePlace = i; 
            while (movePlace > 0 && input[movePlace - 1] > insert){
                input[movePlace] = input[movePlace - 1]; 
                movePlace--; 
            }
            input[movePlace] = insert; 
        }
    }


}


