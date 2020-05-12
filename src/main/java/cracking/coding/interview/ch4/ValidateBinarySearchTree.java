package cracking.coding.interview.ch4;

import java.util.LinkedList;

public class ValidateBinarySearchTree {

    private static boolean checkBinarySearchTree(TreeNode root){

        if(root ==null){
            return true;
        }
        if(root.getLeft() !=null && root.getData() < root.getLeft().getData()){
            return false;
        }else if(root.getRight() !=null && root.getData() >= root.getRight().getData()){
            return false;
        }else{
            return checkBinarySearchTree(root.getLeft()) && checkBinarySearchTree(root.getRight());
        }
    }

    private static boolean checkBinarySearchTreeUsingInOrderTraversal(TreeNode root){
        LinkedList<TreeNode> inorderTraverse = new LinkedList <>();
        performInorderTraversal(root,inorderTraverse);
        System.out.println(inorderTraverse.size());
        for(int i=0; i < inorderTraverse.size()-1;i++){
            System.out.print(inorderTraverse.get(i).getData()+"=>");
            if(inorderTraverse.get(i).getData() > inorderTraverse.get(i+1).getData()){
                return false;
            }
        }
        System.out.println("");

        return true;
    }

    private static void performInorderTraversal(TreeNode root,LinkedList<TreeNode> inorderTraverse){
        if(root ==null ){
            return;
        }
        performInorderTraversal(root.getLeft(),inorderTraverse);
        inorderTraverse.add(root);
        performInorderTraversal(root.getRight(),inorderTraverse);

    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinarySearchTree(new int[]{2,4,6,8,9,2,4,6,9,12});
        System.out.println(checkBinarySearchTree(root));

        root = TreeUtils.buildBinarySearchTree(new int[]{2,4,6,8,9,2,4,6,9,12});
        System.out.println(checkBinarySearchTreeUsingInOrderTraversal(root));
    }
}
