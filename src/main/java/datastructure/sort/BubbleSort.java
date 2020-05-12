package sort;

import java.util.Arrays;

public class BubbleSort {

    private static void perforBubbleSort(int[] input) {
        if (input != null && input.length > 0) {

            for (int i = 1; i < input.length; i++) {
                for (int j = 0; j < input.length - i; j++) {
                    if (input[j] > input[j + 1]) {
                        int temp = input[j];
                        input[j] = input[j + 1];
                        input[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] inputArray = new int[]{12, 25, 69, 2015, 3, 6, 8, 1, 4, 9, 7};

        perforBubbleSort(inputArray);
        Arrays.stream(inputArray).forEach(currentItem -> System.out.print(currentItem + " "));

    }
}
