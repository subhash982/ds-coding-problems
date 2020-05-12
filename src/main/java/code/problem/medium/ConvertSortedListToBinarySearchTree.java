package code.problem.medium;

import code.problem.ds.ListNode;
import code.problem.ds.TreeNode;

import java.util.Arrays;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted linked list: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedListToBinarySearchTree {
    public static TreeNode sortedListToBST(ListNode head) {
       if(head==null){
           return null;
       }
        return helper(head,null);
    }

    public static TreeNode helper(ListNode head,ListNode tail) {

        if(head==null) return null;
        if(head ==tail) return null;
        ListNode fast =head;
        ListNode slow=head;
        while(fast != tail && fast.next!= tail){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left=helper(head,slow);
        root.right=helper(slow.next,tail);
        return root;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode curNode= head;
        curNode.next = new ListNode(-3);
        curNode=curNode.next;
        curNode.next = new ListNode(-0);
        curNode=curNode.next;
        curNode.next = new ListNode(5);
        curNode=curNode.next;
        curNode.next = new ListNode(9);
        curNode=curNode.next;
        TreeNode root = sortedListToBST(head);
    }
}
