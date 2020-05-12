package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {
    public List <List <Integer>> combinationSum(int[] candidates, int target) {
        List <List <Integer>> result = new LinkedList <>();
        backTracing(result, new ArrayList <>(), candidates, target, 0);
        return result;
    }

    public void backTracing(List <List <Integer>> result, List <Integer> output, int[] candidates, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList <>(output));

            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            output.add(candidates[i]);
            backTracing(result, output, candidates, target - candidates[i], i);
            output.remove(output.size() - 1);
        }
    }
}
