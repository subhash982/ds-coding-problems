package code.problem.medium;

import code.problem.ds.ListNode;

/**
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode prev=null;
        ListNode currNode=head;
        while(m>1){
            prev=currNode;
            currNode=currNode.next;
            m--;
            n--;
        }

        ListNode connection=prev;
        ListNode tail=currNode;
        while(n>0){
            ListNode nextNode=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=nextNode;
            n--;

        }

        if(connection!=null){
            connection.next=prev;
        }else{
            head=prev;
        }

        tail.next=currNode;
        return head;

    }
}
