package code.problem.medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int distance = Integer.MAX_VALUE;
        int closestSum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lowIndex = i + 1;
                int highIndex = nums.length - 1;

                while (lowIndex < highIndex) {
                    int sum = nums[lowIndex] + nums[highIndex] + nums[i];
                    int currDistance = Math.abs(target - sum);
                    if (currDistance < distance) {
                        distance = currDistance;
                        closestSum = sum;
                    }

                    if (sum == target) {
                        return target;
                    } else if (sum > target) {
                        highIndex--;
                    } else if (sum < target) {
                        lowIndex++;
                    }
                }
            }
        }
        return closestSum;
    }
}
