package code.problem.easy;

/**
 * 172. Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 */
public class FactorialTrailingZeroes {

    public static int mySolution(int n) {
        int result = 0;
        while (n > 0) {
            int temp =n;
            while(temp%5 ==0){
                result++;
                temp=temp/5;
            }
            n--;
        }

        return result;
    }
    public static int trailingZeroes(int n) {
        if (n < 0)
            return -1;

        int count = 0;
        for (long i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(mySolution(1808548329));
        System.out.println(trailingZeroes(1808548329));
    }
}
