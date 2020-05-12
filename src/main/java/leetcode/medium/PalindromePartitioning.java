package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List <List <String>> partition(String s) {

        List <List <String>> result = new ArrayList <>();
        if (s == null || s.length() == 0) {
            return result;
        }

        ArrayList <String> partition = new ArrayList <String>();//track each possible partition
        addPalindrome(s, 0, partition, result);

        return result;
    }

    private void addPalindrome(String s, int start, ArrayList <String> partition,
                               List <List <String>> result) {
        //stop condition
        if (start == s.length()) {
            ArrayList <String> temp = new ArrayList <String>(partition);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    /**
     * not covered for all the scenario
     * @param s
     * @return
     */
    public static List <List <String>> palindromePartitioningUsingDP(String s) {

        List<String> temp = new ArrayList<String>();
        List <List <String>> result = new ArrayList <>();
        if (s == null)
            return result;

        if (s.length() <= 1) {
            temp.add(s);
            result.add(temp);
            return result;
        }

        int length = s.length();

        int[][] table = new int[length][length];

        // l is length, i is index of left boundary, j is index of right boundary
        for (int l = 1; l <= length; l++) {
            temp = new ArrayList<String>();
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 1 || l == 2) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i + 1][j - 1];
                    }
                    if (table[i][j] == 1) {
                        temp.add(s.substring(i, j + 1));
                    }
                } else {
                    table[i][j] = 0;
                }
            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
