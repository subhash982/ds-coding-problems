package ds.dp;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FindAllPossiblePalindromes {

    public static List <String> findAllPossiblePalindrome(String input) {
        List <String> allPossiblePalindromes = new ArrayList <>();
        int maxLength = 1;
        if (StringUtils.isEmpty(input)) {
            return allPossiblePalindromes;
        } else {
            int lenght = input.length();
            boolean arr[][] = new boolean[lenght][lenght];
            //Length 1
            for (int i = 0; i < lenght; i++) {
                arr[i][i] = true;
            }

            //Length =2
            int start = 0;
            for (int i = 0; i < lenght-1; i++) {
                if (input.charAt(i) == input.charAt(i + 1)) {
                    arr[i][i + 1] = true;
                    start = i;
                    maxLength = 2;
                    allPossiblePalindromes.add("Palindrome [" + input.substring(start, start + maxLength) + "] Lenght [" + maxLength + "]");
                }
            }

            //Length >2
            if (input.length() > 2) {
                for (int k = 3; k < lenght; k++) {
                    for (int i = 0; i < lenght -k + 1; i++) {
                        //End of the String
                        int j = i + k - 1;
                        if (arr[i + 1][j - 1] && input.charAt(i) == input.charAt(j)) {
                            arr[i][j] = true;
                            start = i;
                            maxLength = k;
                            allPossiblePalindromes.add("Palindrome [" + input.substring(start, start + maxLength) + "] Lenght [" + maxLength + "]");
                        }
                    }
                }
            }
        }
        return allPossiblePalindromes;
    }

    public static void main(String[] args) {
        List <String> allPalindromes = findAllPossiblePalindrome("abcbaba");
        for (String currString : allPalindromes) {
            System.out.println(currString);
        }


    }
}
