package code.problem.medium;

import code.problem.ds.ListNode;

/**
 * 2# You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode header = null;
        ListNode currentNode = null;
        int cary = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + cary;
            cary = sum / 10;
            sum = sum % 10;

            if (header == null) {
                header = new ListNode(sum);
                currentNode = header;
            } else {
                currentNode.next = new ListNode(sum);
                currentNode = currentNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;

        }

        //
        while (l1 != null) {
            sum = l1.val + cary;
            cary = sum / 10;
            sum = sum % 10;
            currentNode.next = new ListNode(sum);
            currentNode = currentNode.next;
            l1 = l1.next;

        }

        while (l2 != null) {
            sum = l2.val + cary;
            cary = sum / 10;
            sum = sum % 10;

            currentNode.next = new ListNode(sum);
            currentNode = currentNode.next;

            l2 = l2.next;

        }
        if (cary > 0) {
            currentNode.next = new ListNode(cary);
        }

        return header;
    }
}
