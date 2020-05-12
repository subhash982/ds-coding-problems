package code.problem.medium;

import code.problem.ds.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 116. Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class PopulatingNextRightPointersInEachNode {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //My Solution
        helper(root, 0, new ArrayList <>());
        return root;

    }

    public static Node connectOptimally(Node root) {
        if (root == null) {
            return null;
        }
        //My Solution
        root.next=null;
        optimalSolution(root);
        return root;

    }

    public static void helper(Node root, int level, List <List <Node>> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(new ArrayList <>());
        }

        if(result.get(level).size()!=0){
            result.get(level).get(result.get(level).size()-1).next=root;
        }
        result.get(level).add(root);
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);

    }

    public static void  optimalSolution(Node p)
    {
        // Base case
        if (p == null)
            return;

        // Set the nextRight pointer for p's left child
        if (p.left != null)
            p.left.next = p.right;

        // Set the nextRight pointer for p's right child
        // p->nextRight will be NULL if p is the right most child
        // at its level
        if (p.right != null)
            p.right.next = (p.next != null) ?
                    p.next.left : null;

        // Set nextRight for other nodes in pre order fashion
        optimalSolution(p.left);
        optimalSolution(p.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);
    }
}
