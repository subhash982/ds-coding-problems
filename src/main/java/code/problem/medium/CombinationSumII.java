package code.problem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class CombinationSumII {
    public List <List <Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            output.add(candidates[i]);
            backTracing(result, output, candidates, target - candidates[i], i + 1);
            output.remove(output.size() - 1);
        }
    }
}
