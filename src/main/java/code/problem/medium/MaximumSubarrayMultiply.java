package code.problem.medium;

public class MaximumSubarrayMultiply {
    public static int maxSubArrayMultiply(int[] nums) {
        int curr_max = nums[0];
        int curr_min = nums[0];
        int final_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = curr_max;
            curr_max = Math.max(Math.max(curr_max*nums[i] , curr_min*nums[i]) ,nums[i]);
            curr_min = Math.min(Math.min(temp*nums[i] , curr_min*nums[i]) ,nums[i]);
            if (curr_max > final_max) {
                final_max = curr_max;
            }
        }
        return final_max;
    }
}
