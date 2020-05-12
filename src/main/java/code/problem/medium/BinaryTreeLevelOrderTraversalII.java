package code.problem.medium;

import code.problem.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tempResult = new ArrayList <>();
        if(root==null){
            return tempResult;
        }
        helper(root,0,tempResult);
        List<List<Integer>> result = new ArrayList <>();
        int size=tempResult.size();
        for(int i=0; i < tempResult.size();i++){
            result.add(tempResult.get(size-1-i));
        }


        return result;
    }

    public void helper(TreeNode root, int level, List <List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);

    }
}
