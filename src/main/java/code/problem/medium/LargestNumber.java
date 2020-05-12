package code.problem.medium;

import java.util.Arrays;

/**
 * 179. Largest Number
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(Integer[] nums) {
        String[] numArr = new String[nums.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numArr, (n1, n2) -> (n1+n2).compareTo(n2+n1));

        StringBuilder sb = new StringBuilder();
        for (String s : numArr) {
            sb.append(s);
        }

        while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);

        return sb.toString();


    }
}
