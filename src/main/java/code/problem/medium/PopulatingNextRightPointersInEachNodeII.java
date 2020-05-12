package code.problem.medium;

import code.problem.ds.Node;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //My Solution
        helper(root, 0, new ArrayList <>());
        return root;

    }

    public static void helper(Node root, int level, List <List<Node>> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        if(result.get(level).size()!=0){
            result.get(level).get(result.get(level).size()-1).next=root;
        }
        result.get(level).add(root);
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);

    }
}
