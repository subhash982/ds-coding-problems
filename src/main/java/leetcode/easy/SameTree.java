package leetcode.easy;

import leetcode.ds.TreeNode;

/**
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        return helper(p, q);
    }

    public boolean helper(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else if (p == null && q == null) return true;

        if (p.val != q.val) return false;
        return helper(p.left, q.left) && helper(p.right, q.right);
    }
}
