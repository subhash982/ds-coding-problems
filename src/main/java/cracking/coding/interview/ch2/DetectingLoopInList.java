package cracking.coding.interview.ch2;

import cracking.coding.interview.LinkedListNode;

public class DetectingLoopInList {

    private static boolean detectingLoopInList(LinkedListNode list) {
        LinkedListNode slow = list;
        LinkedListNode fast = list;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                break; //collision
            }
        }
        if (fast == null || fast.getNext() == null) {
            return false;
        }
        slow = list;

        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        if (slow == null) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectingLoopInList(TestDataUtils.prepareLinkedListTestData()));
        System.out.println(detectingLoopInList(TestDataUtils.prepareCircularLinkedListTestData()));
    }
}
