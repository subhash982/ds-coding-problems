package cracking.coding.interview.ch4;

import java.util.LinkedList;
import java.util.List;

public class ListOfDepth {
    private static List<List<TreeNode>> listOfDepth(TreeNode node){
        List<List<TreeNode>> listOfDepth = new LinkedList <>();
        buildListOfDepth(node,listOfDepth,0);

        return listOfDepth;

    }

    private static void buildListOfDepth(TreeNode node,List<List<TreeNode>> listOfDepth,int depth){
        if(node==null){
            return;
        }
        List<TreeNode> list=null;
        if(depth == listOfDepth.size()){
            list=new LinkedList <>();
            listOfDepth.add(list);
        }else{
             list = listOfDepth.get(depth);
        }
        list.add(node);
        buildListOfDepth(node.getLeft(),listOfDepth,depth+1);
        buildListOfDepth(node.getRight(),listOfDepth,depth+1);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtils.buildMinimalBinarySearchTree(new int[]{2,4,6,8,9,2,4,6,9,12});
        List<List<TreeNode>> listOfDepth=listOfDepth(node);
        for(List<TreeNode> list : listOfDepth){
            for(TreeNode currNode : list){
                System.out.print(currNode.getData()+"->");
            }
            System.out.println("");
        }

    }

}
