package code.problem.easy;

public class ReverseInteger {


    /**
     * 7# Reverse Integer
     * Given a 32-bit signed integer, reverse digits of an integer.
     * <p>
     * Example 1:
     * <p>
     * Input: 123
     * Output: 321
     * Example 2:
     * <p>
     * Input: -123
     * Output: -321
     * Example 3:
     * <p>
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
     * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            /*
             * if reverse > Integer.MAX_VALUE / 10
             * 32 bit signed integer range -2147483648 to 2147483647
             */
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reverse = reverse * 10 + pop;

        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-12));
    }
}
