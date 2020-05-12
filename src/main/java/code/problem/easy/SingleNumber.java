package code.problem.easy;

import java.util.HashSet;

/**
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }
        return x;
    }

    public int singleNumberUsingTempSpace(int[] A) {
        HashSet <Integer> set = new HashSet<Integer>();
        for (int n : A) {
            if (!set.add(n))
                set.remove(n);
        }
        return set.iterator().next();
    }
}
