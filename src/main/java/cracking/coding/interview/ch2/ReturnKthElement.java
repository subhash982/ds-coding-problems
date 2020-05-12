package cracking.coding.interview.ch2;

import cracking.coding.interview.LinkedListNode;

public class ReturnKthElement {

    private static LinkedListNode findKthElementFromLast(LinkedListNode node, int kth) {
        LinkedListNode header = node;
        //Move to the kth element from start
        for (int i = 0; i < kth; i++) {
            node = node.getNext();
        }
        LinkedListNode currNode = header;
        LinkedListNode prevNode = null;
        //Move the kth node to last which figured out n-kth from start
        while (node != null) {
            node = node.getNext();
            prevNode = currNode;
            currNode = currNode.getNext();
        }
        //Complexity is O(n)

        return currNode;
    }

    public static void main(String[] args) {
        LinkedListNode header = TestDataUtils.prepareLinkedListTestData();
        TestDataUtils.printListData(header);
        System.out.println(findKthElementFromLast(header, 5).getData());

    }
}
