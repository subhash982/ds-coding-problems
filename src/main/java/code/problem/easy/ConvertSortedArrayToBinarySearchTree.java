package code.problem.easy;

import code.problem.ds.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {

        return helper(0, nums.length - 1, nums);
    }

    public static TreeNode helper(int startIndex, int endIndex, int[] nums) {
        if (startIndex >= endIndex) {
            return null;
        }
        int mid = startIndex + (endIndex - startIndex) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(startIndex, mid - 1, nums);
        root.right = helper(mid + 1, endIndex, nums);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
