package code.problem.easy;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = null;
        ListNode currNode = null;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            while (l1 != null) {
                if (mergedList == null) {
                    if (l1.val > l2.val) {
                        mergedList = new ListNode(l2.val);
                        l2 = l2.next;
                        currNode = mergedList;
                    } else {
                        mergedList = new ListNode(l1.val);
                        l1 = l1.next;
                        currNode = mergedList;
                    }
                } else {
                    if (l2 != null && l1.val > l2.val) {
                        currNode.next = new ListNode(l2.val);
                        l2 = l2.next;
                        currNode = currNode.next;
                    } else {
                        currNode.next = new ListNode(l1.val);
                        l1 = l1.next;
                        currNode = currNode.next;
                    }
                }


            }
            if (l2 != null) {
                currNode.next = l2;
            }

        }
        return mergedList;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        //node1.next =new ListNode(2);
        // node1.next.next =new ListNode(4);
        printNodeList(node1);

        ListNode node2 = new ListNode(1);
        // node2.next =new ListNode(3);
        //node2.next.next =new ListNode(4);

        printNodeList(node2);

        ListNode merged = mergeTwoLists(node1, node2);
        printNodeList(merged);


    }

    public static void printNodeList(ListNode merged) {
        while (merged != null) {
            System.out.print(merged.val + "->");
            merged = merged.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
