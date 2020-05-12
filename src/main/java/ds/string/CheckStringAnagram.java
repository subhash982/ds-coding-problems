package ds.string;

import java.util.Arrays;
import java.util.HashMap;

public class CheckStringAnagram {


    public static boolean isStringAnagramUsingMap(String input1, String input2) {
        HashMap<Character, Integer> memo = new HashMap <>();
        if (input1.length() != input2.length()) {
            return false;
        }

        //Store all the character count to map
        for(int i=0; i< input1.length();i++){
            if(memo.get(input1.charAt(i))==null){
                memo.put(input1.charAt(i),1);
            }else {
                memo.put(input1.charAt(i),memo.get(input1.charAt(i))+1);
            }
        }

        //Now decrease the count from map using the second string
        for(int i=0; i< input2.length();i++){
            if(memo.get(input2.charAt(i))==null || memo.get(input2.charAt(i)) ==0){
                System.out.println(memo);
                return false;
            }else {
                memo.put(input2.charAt(i),memo.get(input2.charAt(i))-1);
            }
        }

        return true;
    }
    /**
     * Check if 2 string are the anagram of each other.
     * Anagram - Strings are anagram if both have the same number of characters
     *
     * @param input1
     * @param input2
     * @return
     */
    public static boolean isStringAnagram(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        char[] charArr1 = input1.toCharArray();
        char[] charArr2 = input2.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        input1 = new String(charArr1);
        input2 = new String(charArr2);

        return input1.equals(input2);
    }

    public static void main(String[] args) {
        System.out.println(isStringAnagram("subhash", "subhash"));

        System.out.println(isStringAnagramUsingMap("subhash", "subhash"));
    }
}
