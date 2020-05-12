package code.problem.easy;

import java.util.Arrays;

/**
 * 169. Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums.length <= 2){
            return nums[0];
        }
        Arrays.sort(nums);
        int mid = (nums.length/2);
        return nums[mid];

    }
}
