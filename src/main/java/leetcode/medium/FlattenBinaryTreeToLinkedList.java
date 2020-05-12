package leetcode.medium;

import leetcode.ds.TreeNode;

import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.

 For example, given the following tree:

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:

 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack <>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode currNode= stack.pop();
            if(currNode.right!=null){
                stack.push(currNode.right);
            }

            if(currNode.left!=null){
                stack.push(currNode.left);
            }

            if(!stack.isEmpty()){
                currNode.right=stack.peek();
            }
            currNode.left=null;
        }

    }
}
