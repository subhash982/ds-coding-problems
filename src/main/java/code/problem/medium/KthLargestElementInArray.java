package code.problem.medium;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int larget=0;
        int length =nums.length-1;
        while(larget!=k){
            larget++;
            length--;

        }
        return nums[length+1];
    }

    public static void main(String[] args) {
        System.out.print(findKthLargest(new int[]{3,2,1,5,6,4} ,2));
    }
}
