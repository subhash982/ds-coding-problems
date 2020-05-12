package code.problem.medium;

import code.problem.ds.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class ConstructBinaryTreefromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);

    }

    public TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart < 0 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postStart]) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(postStart - (inEnd - inIndex + 1), inStart, inIndex - 1, postorder, inorder);
        root.right = helper(postStart - 1, inIndex + 1, inEnd, postorder, inorder);


        return root;


    }

}
