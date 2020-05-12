package code.problem.easy;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarraySum {


    public static int maxSubArraySol(int[] nums) {
        int curr_max = nums[0];
        int final_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(curr_max + nums[i], nums[i]);
            if (curr_max > final_max) {
                final_max = curr_max;
            }
        }
        return final_max;
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
                sum += nums[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, 3, 4, -1, 2,}));
        System.out.println(maxSubArraySol(new int[]{-2, 1, 3, 4, -1, 2,}));
    }
}
