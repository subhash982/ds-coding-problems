package cracking.coding.interview.ch4;


public class CheckBalancedTree {

    //Height of the each subtree of a node should not differ more than 2
    private static boolean isTreeBalanced(TreeNode root){
        if(root==null) return true;
        int heightDiff = getHeight(root.getLeft()) -getHeight(root.getRight());
        if(Math.abs(heightDiff) > 1){
            return false;
        }else{
            return isTreeBalanced(root.getLeft()) && isTreeBalanced(root.getRight());
        }
    }

    private static int getHeight(TreeNode node){
        if(node==null) return -1;
         return Math.max(getHeight(node.getLeft()),getHeight(node.getRight()))+1;
    }

    private static int checkHeight(TreeNode node){
        if(node==null) return -1;
        int leftHeight = checkHeight(node.getLeft());
        if(leftHeight ==Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(node.getRight());
        if(rightHeight==Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        int heightDiff = leftHeight-rightHeight;
        if(Math.abs(heightDiff)>1){
            return Integer.MIN_VALUE;

        }else{
            return Math.max(leftHeight,rightHeight)+1;
        }

    }

    private static boolean isTreeBalancedUsingCheckHeight(TreeNode root){
        return checkHeight(root)!=Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinarySearchTree(new int[]{3,45,21,78,43,1,2,7,8,90});
        System.out.println(isTreeBalanced(root));

        root = TreeUtils.buildMinimalBinarySearchTree(new int[]{3,45,21,78,43,1,2,7,8});
        System.out.println(isTreeBalanced(root));

        root = TreeUtils.buildBinarySearchTree(new int[]{3,45,21,78,43,1,2,7,8,90});
        System.out.println(isTreeBalancedUsingCheckHeight(root));

        root = TreeUtils.buildMinimalBinarySearchTree(new int[]{3,45,21,78,43,1,2,7,8});
        System.out.println(isTreeBalancedUsingCheckHeight(root));
    }
}
