package ds.dp;

import java.util.Arrays;

public class FindLongestPalindrome {

    public static String findLongestPalindrome(String input) {
        int length = input.length();
        int maxLength = 1;
        boolean arr[][] = new boolean[length][length];
        //Length 1 - Single character will always be a palindrome
        for (int i = 0; i < length; ++i)
            arr[i][i] = true;

        //Length 2 - check for the length 2 string
        int start = 0;
        for (int i = 0; i < length - 1; ++i) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                arr[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        //Length >2 -Generlize the solution for the string length greater than 2
        for (int k = 3; k <= length; ++k) {
            // Fix the starting index
            for (int i = 0; i < length - k + 1; ++i) {
                //Get the ending index of substring from starting index i and length k
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
        // System.out.println("Length : " + maxLength);
        return "Found longest palindrome in [" + input + "]with the length [" + maxLength + "] is [" + input.substring(start, start + maxLength) + "]";
    }

    public static void main(String[] args) {
        System.out.println("Printing the program argument ");
        Arrays.stream(args).forEach(programArs -> System.out.println(programArs));

        String[] inputData = new String[]{"agbdba", "geeksforgeeks", "forgeeksskeegfor"};
        Arrays.stream(inputData).forEach(inputString -> System.out.println(findLongestPalindrome(inputString)));


    }
}
