package leetcode.medium;

import leetcode.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
    public List <List <Integer>> pathSum(TreeNode root, int sum) {
        List <List <Integer>> result = new ArrayList <>();
        List <Integer> tempResult = new ArrayList <>();
        helper(root, result, tempResult, sum);
        return result;
    }

    public void helper(TreeNode root, List <List <Integer>> result, List <Integer> tempResult, int target) {
        if (root == null) {
            return;
        }
        tempResult.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null) {
            if (target == 0) {
                result.add(new ArrayList <>(tempResult));
            }
        }

        helper(root.left, result, tempResult, target);
        helper(root.right, result, tempResult, target);
        tempResult.remove(tempResult.size() - 1);


        target += root.val;
    }
}
