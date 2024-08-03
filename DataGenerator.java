import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataGenerator {
    
    public static void main(String[] args) throws Exception {
        int[] array = getRandomArrayByThousands(25);
        //Main.printArray(array);

        String filePrefix = "./testdata/07_2024_data/";
        String filename = filePrefix + "25k-random.dat";
        writeArrayToFile(filename, array);
    }

    public static int[] getRandomArrayByThousands(int numk){
        int[] array = new int[numk * 1000]; 
        addRandomNumbers(array, 0, array.length - 1);
        return array;
    }

    public static int[] getSortedArrayByThousands(int numk, int increment){
        int[] array = new int[numk * 1000];
        int end = numk * 1000 - 1;  
        addSortedNumbers(array, 0, end, increment);
        return array; 
    }

    public static void writeArrayToFile (String filename, int[]x) throws IOException{
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < x.length; i++) {
            // Maybe:
            if (i == x.length - 1 ) {
                outputWriter.write(Integer.toString(x[i]));;
            } else {
                outputWriter.write(x[i] + ","); 
            }
            // Or:
            //outputWriter.write(Integer.toString(x[i]));
            //outputWriter.newLine();
        }
        outputWriter.flush();  
        outputWriter.close();  
    }

    public static int[] getPartiallySortedArrayByThousand(int numk){
        int[] array = new int[numk * 1000]; 

        for (int i = 0; i < numk; i++){
            int start = i * 1000;
            int end = start + 999; 

            if (i % 2 == 0) {
                addSortedNumbers(array, start, end, 1);
            } else {
                addRandomNumbers (array, start, end); 
            }
        }

        return array; 
    }

    // addSortedNumbers can generate sorted array increasing or decreasing controlled by increment
    // start: first element of array
    // end: last element of array, not the length
    public static void addSortedNumbers(int[] array, int start, int end, int increment){
        int randomStart = 0 + (int)(Math.random() * ((100000 - 0) + 1));
        for (int i = start; i <= end; i++){
            array[i] = randomStart;
            randomStart += increment;
        }
    }

    public static void addRandomNumbers (int[] array, int start, int end){
        for (int i = start; i <= end; i++){
            array[i] = 0 + (int)(Math.random() * ((100000 - 0) + 1));
        }
    }



}
