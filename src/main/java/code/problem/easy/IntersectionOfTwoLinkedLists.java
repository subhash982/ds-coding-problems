package code.problem.easy;

import code.problem.ds.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * begin to intersect at node c1.
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * Example 2:
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int listASize = getListSize(headA);
        int listBSize = getListSize(headB);
        if(listASize > listBSize){
            int diff = listASize-listBSize;
            while(diff > 0){
                headA=headA.next;
                diff--;
            }
        }else{
            int diff = listBSize-listASize;
            while(diff > 0){
                headB=headB.next;
                diff--;
            }
        }

        while(headA!=null && headB!=null && headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

       return headA;

    }

    private int getListSize(ListNode head){
        int size = 0;
        while(head!=null){
            size++;
            head=head. next;
        }
        return size;
    }
}
