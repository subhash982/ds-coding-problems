package code.problem.medium;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String input) {
        if (input == null || input.trim().length() == 0) {
            return input;
        }
        int length = input.length();
        int maxLength = 1;
        //Using Dynamic programming
        boolean arr[][] = new boolean[length][length];
        int start = 0;
        for (int k = 1; k <= length; ++k) {
            //k = length of the string
            // Fix the starting index
            for (int i = 0; i < length - k + 1; ++i) {
                //Get the ending index of substring from starting index i and length k
                if (k == 1) {
                    arr[i][i] = true;
                } else if (k == 2) {
                    if (input.charAt(i) == input.charAt(i + 1)) {
                        arr[i][i + 1] = true;
                        start = i;
                        maxLength = 2;
                    }
                } else {
                    int j = i + k - 1;

                /* checking for sub-string from ith index to jth index if str.charAt(i+1) to
                * str.charAt(j-1) is a palindrome
                */
                    if (arr[i + 1][j - 1] && input.charAt(i) == input.charAt(j)) {
                        arr[i][j] = true;
                        if (k > maxLength) {
                            start = i;
                            maxLength = k;
                        }
                    }
                }

            }
        }
        return input.substring(start, (maxLength + start));


    }
}
