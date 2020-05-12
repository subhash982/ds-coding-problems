package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 4Sum
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * The solution set must not contain duplicate quadruplets.
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public List <List <Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List <List <Integer>> result = new LinkedList <>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (sum + nums[low] + nums[high] == target) {
                        List <Integer> quardent = new LinkedList <>();
                        quardent.add(nums[i]);
                        quardent.add(nums[j]);
                        quardent.add(nums[low]);
                        quardent.add(nums[high]);
                        result.add(quardent);
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    } else if (sum + nums[low] + nums[high] > target) {
                        high--;
                    } else {
                        low++;
                    }

                }
            }
        }
        return result;
    }
}