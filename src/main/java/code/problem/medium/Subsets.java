package code.problem.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List <List <Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        helper(nums, 0, result, new ArrayList <>());
        return result;
    }

    public static void helper(int[] nums, int startNum, List <List <Integer>> result, List <Integer> currSequence) {

        if (currSequence.size() == nums.length) {
            result.add(new ArrayList <>(currSequence));
            return ;
        } else {
            result.add(new ArrayList <>(currSequence));
            for (int i = startNum; i < nums.length; i++) {
                currSequence.add(nums[i]);
                helper(nums, i+1,result, currSequence);
                currSequence.remove(currSequence.size() - 1);

            }
        }


    }

    public static void main(String[] args) {
System.out.print(subsets(new int[]{1,2,3}));
    }
}
