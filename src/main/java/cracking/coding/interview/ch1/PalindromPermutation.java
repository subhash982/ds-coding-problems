package cracking.coding.interview.ch1;

import java.util.HashMap;
import java.util.Map;

/**
 * write a method if given string is a permutation of a palindrom
 */
public class PalindromPermutation {

    private static boolean isPremutationOfPalindrome(String inputStr) {
        Map <Character, Integer> charCount = new HashMap <>();
        for (char ch : inputStr.toCharArray()) {
            if (charCount.get(ch) == null) {
                charCount.put(ch, 1);
            } else {
                charCount.put(ch, charCount.get(ch) + 1);
            }
        }
        boolean isOneCharFound = false;
        for (Map.Entry <Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (isOneCharFound) {
                    return false;
                } else {
                    isOneCharFound = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPremutationOfPalindrome("baabaanc"));
    }
}
