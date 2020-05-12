package leetcode.medium;

import leetcode.ds.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd,int[] preorder, int[] inorder) {
        if(preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex =0;
        for(int i=inStart; i <= inEnd; i++){
            if(inorder[i] == preorder[preStart]){
                inIndex=i;
                break;
            }
        }
        root.left=helper(preStart+1,inStart,inIndex-1,preorder,inorder);
        root.right=helper(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);

        return root;



    }
}
