package code.problem.medium;

import code.problem.ds.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current=temp;
        while(current.next!=null &&  current.next.next!=null){
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;

            firstNode.next=secondNode.next;
            current.next=secondNode;
            current.next.next=firstNode;
            current=current.next.next;

        }

        return temp.next;
    }
}
