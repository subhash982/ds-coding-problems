package leetcode.medium;

import java.util.Arrays;

/**
 * 80.Remove Duplicates from Sorted Array II
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 2;
        for (int right = 2; right < nums.length; right++) {
            if (nums[left - 2] != nums[right]) {
                nums[left++] = nums[right];
            }

        }
        return left;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.print(removeDuplicates(arr));
        Arrays.stream(arr).forEach(item -> System.out.print(item + " "));
    }
}
