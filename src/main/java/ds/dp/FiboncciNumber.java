package ds.dp;

import java.util.Arrays;

public class FiboncciNumber {

    public static int printFibonacciSeriesUsingDP(int number) {
        int[] fibSeries = new int[number + 1];
        fibSeries[0] = 0;
        fibSeries[1] = 1;
        for (int i = 2; i <= number; i++) {
            fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
        }
        Arrays.stream(fibSeries).forEach(fibValue -> System.out.print(fibValue + " "));
        System.out.println("");
        return fibSeries[number];
    }

    public static int printFibonacciSeriesUsingrecursion(int number) {
        if(number <= 1){
            return number;
        }
        int fibNumber = printFibonacciSeriesUsingrecursion(number-1)+printFibonacciSeriesUsingrecursion(number-2);
        return fibNumber;
    }


    public static void main(String[] args) {
        System.out.println("Finding the fibonacci number using dynamic programming");
        System.out.println(printFibonacciSeriesUsingDP(4));
        System.out.println(printFibonacciSeriesUsingDP(10));

        System.out.println("Finding the fibonacci number using the recursion");
        System.out.println(printFibonacciSeriesUsingrecursion(4));
        System.out.println(printFibonacciSeriesUsingrecursion(10));
    }
}
