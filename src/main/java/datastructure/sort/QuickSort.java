package sort;

import java.util.Arrays;

public class QuickSort {

    private static void performQuickSort(int[] input, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;

        int pIndex = performPartition(input, startIndex, endIndex);
        performQuickSort(input, startIndex, pIndex - 1);
        performQuickSort(input, pIndex + 1, endIndex);

    }

    private static int performPartition(int[] input, int startIndex, int endIndex) {
        int pivot = input[endIndex];
        int pIndex = startIndex;
        for(int i=startIndex;i < endIndex;i++){
            if(input[i] <= pivot){
                int temp = input[pIndex];
                input[pIndex] = input[i];
                input[i]=temp;
                pIndex=pIndex+1;

            }

        }
        //Swap the pIndex with Pivot
        input[endIndex] = input[pIndex];
        input[pIndex] = pivot;


        return pIndex;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{3, 6, 8, 1, 4, 9, 3, 7};

        performQuickSort(inputArray, 0, inputArray.length - 1);
        Arrays.stream(inputArray).forEach(currentItem -> System.out.print(currentItem + " "));
    }
}
