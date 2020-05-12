package code.problem.medium;

import code.problem.ds.ListNode;

/**
 * 86. Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (head != null) {
            if (head.val < x) {
                if (beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = head;

                } else {
                    beforeEnd.next = head;
                    beforeEnd = head;

                }
                head = head.next;
                beforeEnd.next = null;

            } else {
                if (afterStart == null) {
                    afterStart = head;
                    afterEnd = head;

                } else {
                    afterEnd.next = head;
                    afterEnd = head;

                }
                head = head.next;
                afterEnd.next = null;
            }

        }

        if (beforeEnd != null) {
            beforeEnd.next = afterStart;
        }

        return beforeStart!=null ? beforeStart : afterStart;

    }
}
