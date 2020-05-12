package leetcode.medium;

import leetcode.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList <>();
        if(root==null){
            return result;
        }
        helper(root,0,result);
        return result;
    }

    public void helper(TreeNode root, int level, List <List <Integer>> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList <>());
        }

        result.get(level).add(root.val);
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);

    }
}
