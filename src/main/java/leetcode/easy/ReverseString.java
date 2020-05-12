package leetcode.easy;

/**
 * 344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int startIndex = 0;
        int endIndex = s.length - 1;
        while (startIndex < endIndex) {
            if (s[startIndex] != endIndex) {
                char temp = s[startIndex];
                s[startIndex] = s[endIndex];
                s[endIndex] = temp;
            }
            startIndex++;
            endIndex--;
        }
    }
}
