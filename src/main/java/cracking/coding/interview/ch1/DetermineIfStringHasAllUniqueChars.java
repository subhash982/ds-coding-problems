package cracking.coding.interview.ch1;

import java.util.Arrays;

public class DetermineIfStringHasAllUniqueChars {

    /**
     * Solution 1 - Using the Java 8 feature
     * @param inputStr
     * @return
     */
    private static boolean isAllUniqueCharsUsingJava8(String inputStr) {
        String[] allChars = inputStr.split("");
        long count = Arrays.stream(allChars).distinct().count();
        return allChars.length == count;
    }

    /**
     * Optimised solution with using the intermediate store
     * @param inputStr
     * @return
     */
    private static boolean isAllUniqueChars(String inputStr) {
        int checker = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            int ch = inputStr.charAt(i);
            if ((checker & (1 << ch)) > 0) {
                return false;
            }

            checker |= (1 << ch);
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAllUniqueCharsUsingJava8("qwertyuio"));
        System.out.println(isAllUniqueCharsUsingJava8("qweortyuio"));

        System.out.println(isAllUniqueChars("qwertyuio"));
        System.out.println(isAllUniqueChars("qweortyuio"));
    }

}
