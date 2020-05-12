package leetcode.medium;

import leetcode.ds.ListNode;

/**
 * 148. Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList {
    public static  ListNode sortList(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            temp=slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next=null;

        ListNode leftSide= sortList(head);
        ListNode rightSide = sortList(slow);

        return mergeSubList(leftSide,rightSide);


    }

    public static  ListNode mergeSubList(ListNode left,ListNode right) {
        ListNode dummyNode = new ListNode(0);
        ListNode mergedcurrNode=dummyNode;
        while(left!=null && right!=null){
            if (left.val < right.val) {
                mergedcurrNode.next = left;
                left = left.next;
            } else {
                mergedcurrNode.next = right;
                right = right.next;
            }

            mergedcurrNode=  mergedcurrNode.next;

        }

        if(left!=null){
            mergedcurrNode.next = left;
            left=left.next;
        }
        if(right!=null){
            mergedcurrNode.next = right;
            right=right.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode crrNose =head;
        crrNose.next=new ListNode(2);
        crrNose=crrNose.next;
        crrNose.next=new ListNode(1);
        crrNose=crrNose.next;
        crrNose.next=new ListNode(3);
        crrNose=crrNose.next;

        head =sortList(head);
        System.out.print(sortList(head));
        while(head!=null){
            System.out.print(head.val+"==");
            head=head.next;
        }

    }
}
