package leetcode.medium;

import leetcode.ds.ListNode;

/**
 * 83.Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return null;
        }
        ListNode dummy =new ListNode(0);

        ListNode preNode=dummy;
        ListNode currNode=head;
        ListNode realNode=dummy;
        while(currNode!=null){
            if((preNode==dummy || preNode.val!=currNode.val)){
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
