package ds.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void performSelectionSort(int[] inputArray){
        if(inputArray==null || inputArray.length==0){
            return;
        }


        for(int i=0;i<inputArray.length;i++){
            int minIndex = i;
            //Find the minimum element index in the array [i+1...n]
            for(int j=i+1;j < inputArray.length;j++){
                if(inputArray[minIndex] > inputArray[j]){
                    minIndex = j;
                }
            }

            //Swap the ith element with the minimum index element
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;

        }
    }


    public static void main(String[] args) {
        int [] inputArray = new int[] {12,25,69,2015,3,6,8,1,4,9,7};

        performSelectionSort(inputArray);
        Arrays.stream(inputArray).forEach(currentItem -> System.out.print(currentItem+" "));
    }
}
