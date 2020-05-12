package code.problem.medium;

import code.problem.ds.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 Return the linked list sorted as well.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5
 Example 2:

 Input: 1->1->1->2->3
 Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode dummy =new ListNode(0);

        ListNode preNode=dummy;
        ListNode currNode=head;
        ListNode realNode=dummy;
        while(currNode!=null){
            if((preNode==dummy || preNode.val!=currNode.val) && (currNode.next==null || currNode.val !=currNode.next.val)){
                realNode.next=currNode;
                realNode=currNode;
            }
            preNode=currNode;
            currNode=currNode.next;
            preNode.next=null;

        }


        return dummy.next;
    }
}
