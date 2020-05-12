package leetcode.medium;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] output = new int[]{-1, -1};
        int startIndex = 0;
        for (startIndex = 0; startIndex < nums.length; startIndex++) {
            if (target == nums[startIndex]) {
                output[0] = startIndex;
                output[1] = startIndex;
                break;


            }
        }
        startIndex++;
        for (; startIndex < nums.length; startIndex++) {
            if (target == nums[startIndex]) {
                output[1] = startIndex;

            }
        }
        return output;

    }
}
