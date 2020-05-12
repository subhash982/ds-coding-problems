package cracking.coding.interview.ch2;

import cracking.coding.interview.LinkedListNode;

import java.util.HashSet;

public class RemoveDuplicateFromUnsortedList {

    private static void removeDuplicateFromListUsingBuffer(LinkedListNode node) {
        HashSet <Integer> listElement = new HashSet <>();
        LinkedListNode previous = null;
        LinkedListNode header = node;
        while (node != null) {
            if (listElement.contains(node.getData())) {
                previous.setNext(node.getNext());
            } else {
                listElement.add(node.getData());
                previous = node;
            }


            node = node.getNext();
        }

    }

    private static void removeDuplicateFromList(LinkedListNode node) {

        LinkedListNode current = node;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == current.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }


    }

    public static void main(String[] args) {


        LinkedListNode header = TestDataUtils.prepareLinkedListTestData();
        TestDataUtils.printListData(header);
        removeDuplicateFromListUsingBuffer(header);
        TestDataUtils.printListData(header);

        System.out.println("\n========================================");
        header = TestDataUtils.prepareLinkedListTestData();
        TestDataUtils.printListData(header);
        removeDuplicateFromList(header);
        TestDataUtils.printListData(header);

    }


}
