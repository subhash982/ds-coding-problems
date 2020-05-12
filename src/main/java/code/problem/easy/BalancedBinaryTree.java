package code.problem.easy;

import code.problem.ds.TreeNode;

/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }


    int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
