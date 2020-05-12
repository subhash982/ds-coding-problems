package cracking.coding.interview.ch4;

public class FindSuccessorOfNode {

    private static  TreeNode inorderSuccessor(TreeNode node){
        if(node==null){
            return null;
        }
        if(node.getRight()!=null){
            return leftMostChile(node.getRight());
        }else{
            TreeNode q=node;
            TreeNode parent=q.getParent();
            if(parent!=null && parent.getLeft()!=q){
                //Pareant is not null and node is not a left child of parent
                q=parent;
                parent=parent.getParent();

            }
            return parent;
        }

    }

    private static  TreeNode leftMostChile(TreeNode node){
        if(node==null){
            return null;
        }
        while(node.getLeft()!=null){
            node=node.getLeft();
        }
        return node;
    }
}
