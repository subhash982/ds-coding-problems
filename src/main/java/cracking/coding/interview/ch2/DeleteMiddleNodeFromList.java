package cracking.coding.interview.ch2;

import cracking.coding.interview.LinkedListNode;

public class DeleteMiddleNodeFromList {
    private static boolean deleteMiddleNode(LinkedListNode middleNode){
        if(middleNode==null && middleNode.getNext()==null){
            return false;
        }

        LinkedListNode nextNode = middleNode.getNext();
        middleNode.setData(nextNode.getData());
        middleNode.setNext(nextNode.getNext());
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode header=TestDataUtils.prepareLinkedListTestData();
        TestDataUtils.printListData(header);
        deleteMiddleNode(header.getNext().getNext().getNext());
        TestDataUtils.printListData(header);
    }
}
