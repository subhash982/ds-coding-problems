package sort;

import java.util.Arrays;

public class MergeSort {

    private static void performMergeSort(int[] input) {
        int length = input.length;
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = input[i];

        }

        for (int i = mid; i < length; i++) {
            right[i - mid] = input[i];

        }
        performMergeSort(left);
        performMergeSort(right);
        performMerge(left, right, input);
    }

    private static void performMerge(int[] left, int[] right, int[] input) {
        int nLength = left.length;
        int rLength = right.length;
        int i=0, j=0, k = 0;
        while(i < nLength && j<rLength){
            if(left[i] < right[j] ){
                input[k]=left[i];
                i++;
            }else{
                input[k]=right[j];
                j++;
            }
            k++;
        }

        while(i < nLength ){
            input[k]=left[i];
            i++;
            k++;
        }

        while(j<rLength){
            input[k]=right[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        int[] inputArray = new int[]{12, 25, 69, 2015, 3, 6, 8, 1, 4, 9, 7};

        performMergeSort(inputArray);
        Arrays.stream(inputArray).forEach(currentItem -> System.out.print(currentItem + " "));
    }
}
