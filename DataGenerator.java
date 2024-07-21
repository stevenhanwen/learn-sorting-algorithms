

public class DataGenerator {
    
    public static void main(String[] args) throws Exception {
        int[] testArray = getPartiallySortedArrayByThousand(2);
        Main.printArray(testArray);

        System.out.println(0 + (int)(Math.random() * ((100000 - 0) + 1)));
    }
    public static int[] getPartiallySortedArrayByThousand(int numk){
        int[] array = new int[numk * 1000]; 

        for (int i = 0; i < numk; i++){
            int start = i * 1000;
            int end = start + 999; 

            if (i % 2 == 0) {
                addSortedNumbers(array, start, end);
            } else {
                addRandomNumbers (array, start, end); 
            }
        }

        return array; 
    }

    public static void addSortedNumbers(int[] array, int start, int end){
        int randomStart = 0 + (int)(Math.random() * ((100000 - 0) + 1));
        for (int i = start; i <= end; i++){
            array[i] = randomStart;
            randomStart++;
        }
    }

    public static void addRandomNumbers (int[] array, int start, int end){
        for (int i = start; i <= end; i++){
            array[i] = 0 + (int)(Math.random() * ((100000 - 0) + 1));
        }
    }


}
