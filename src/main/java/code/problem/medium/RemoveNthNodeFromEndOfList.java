package code.problem.medium;

import code.problem.ds.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fastNode = dummyNode;
        ListNode slowNode = dummyNode;
        if (head != null) {
            //Move to the kth element from start
            for (int i = 0; i <= n; i++) {
                fastNode = fastNode.next;
            }
            while (fastNode != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;

            }
            slowNode.next = slowNode.next.next;

        }

        return dummyNode.next;
    }
}
