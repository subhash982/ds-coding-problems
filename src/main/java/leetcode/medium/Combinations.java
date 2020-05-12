package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {
    public static List <List <Integer>> combine(int n, int k) {
        List <List <Integer>> result = new ArrayList <>();
        if (n == 0 || k == 0) return result;
        helper(n, k, 1, result, new ArrayList <>());
        return result;
    }

    public static void helper(int n, int k, int startNum, List <List <Integer>> result, List <Integer> currSequence) {
        if (k == 0) {
            result.add(new ArrayList <>(currSequence));
        } else {
            for (int i = startNum; i <= n; i++) {
                currSequence.add(i);
                helper(n, k - 1, i + 1, result, currSequence);
                currSequence.remove(currSequence.size() - 1);

            }
        }


    }

    public static void main(String[] args) {
        System.out.print(combine(4, 2));
    }
}
