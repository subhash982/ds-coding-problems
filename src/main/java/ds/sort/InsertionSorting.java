package ds.sort;

import java.util.Arrays;

public class InsertionSorting {

    /**
     * Perform the insertion search
     * @param inputArray
     */
    public static void performInsertionSorting(int [] inputArray){
        if(inputArray==null || inputArray.length ==0){
            return;
        }

        for(int i=1 ; i < inputArray.length;++i){
            int key = inputArray[i];
            int hole=i;
            /* Move elements of arr[0..i-1], that are  greater than key, to one position ahead
               of their current position */
            while(hole>0 && inputArray[hole-1] > key){
                inputArray[hole] =inputArray[hole-1];
                hole--;
            }
            inputArray[hole] = key;
        }

    }
    public static void main(String[] args) {
        int [] inputArray = new int[] {3,6,8,1,4,9,3,7};

        performInsertionSorting(inputArray);
        Arrays.stream(inputArray).forEach(currentItem -> System.out.print(currentItem+" "));
    }
}
