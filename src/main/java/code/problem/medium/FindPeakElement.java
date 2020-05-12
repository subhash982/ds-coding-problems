package code.problem.medium;

/**
 * 162. Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        //O(n)
        int max = nums[0];
        int index = 0;
        for (int i = 1; i <= nums.length - 2; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            int next = nums[i + 1];

            if (curr > prev && curr > next && curr > max) {
                index = i;
                max = curr;
            }
        }

        if (nums[nums.length - 1] > max) {
            return nums.length - 1;
        }

        return index;


    }

    public int findPeakElement(int arr[], int n) {
        return findPeakElementUsingRecursion(arr, 0, n - 1, n);
    }

    // A binary search based function that returns index of a peak
    // element
    public int findPeakElementUsingRecursion(int[] nums, int low, int high, int n) {
        // Find index of middle element
        int mid = low + (high - low) / 2;
        if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == n - 1 || nums[mid + 1] <= nums[mid]))
            return mid;
        else if (mid > 0 && nums[mid - 1] > nums[mid])
            return findPeakElementUsingRecursion(nums, low, (mid - 1), n);
        else return findPeakElementUsingRecursion(nums, (mid + 1), high, n);


    }
}
