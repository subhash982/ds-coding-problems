package string;

import org.apache.commons.lang3.StringUtils;

public class StringPalindrome {

    /**
     * Check if string is palindrome or not using the recursive reverse method
     * to rever the string before test
     *
     * @param input
     * @return true if String is Palindrome
     */
    public static boolean isPalindrome(String input) {
        if (StringUtils.isEmpty(input)) {
            return false;
        }
        return input.equals(reverse(input));
    }

    /**
     * Check if string is palindrome using the resursion and avoid the string reversal step
     *
     * @param input
     * @return
     */
    public static boolean isPalindromeUsingRecursion(String input) {
        if (StringUtils.isEmpty(input)) {
            return false;
        }
        return isPalindromeRec(input, 0, input.length() - 1);
    }

    /**
     * @param input
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static boolean isPalindromeRec(String input, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return true;
        }

        if (input.charAt(startIndex) != input.charAt(endIndex)) {
            return false;
        }

        if (startIndex < endIndex + 1) {
            return isPalindromeRec(input, startIndex + 1, endIndex - 1);
        }

        return true;
    }

    /**
     * Java method to reverse String using recursion
     *
     * @param input
     * @return reversed String of input
     */
    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("This is not a palindrome string"));
        System.out.println(isPalindrome("asdfghjklkjhgfdsa"));


        System.out.println(isPalindromeUsingRecursion("This is not a palindrome string"));
        System.out.println(isPalindromeUsingRecursion("abbbbba"));
    }
}
