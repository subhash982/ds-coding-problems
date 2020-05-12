package code.problem.medium;

import code.problem.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List <List <Integer>> zigzagLevelOrder(TreeNode root) {
        List <List <Integer>> result = new ArrayList <>();
        if (root == null) return result;

        Stack <TreeNode> stack = new Stack <>();
        stack.push(root);
        boolean directionflag = false;

        int level = 0;
        while (!stack.isEmpty()) {
            Stack <TreeNode> tempStack = new Stack <>();
            if (level == result.size()) {
                result.add(new ArrayList <>());
            }
            while (!stack.isEmpty()) {
                TreeNode tempNode = stack.pop();
                result.get(level).add(tempNode.val);
                if (!directionflag) {
                    if (tempNode.left != null)
                        tempStack.push(tempNode.left);
                    if (tempNode.right != null)
                        tempStack.push(tempNode.right);
                } else {
                    if (tempNode.right != null)
                        tempStack.push(tempNode.right);
                    if (tempNode.left != null)
                        tempStack.push(tempNode.left);
                }
            }
            // for changing direction
            directionflag = !directionflag;
            level++;
            stack = tempStack;
        }
        return result;
    }
}
