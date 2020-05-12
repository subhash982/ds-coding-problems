package cracking.coding.interview.ch2;

import cracking.coding.interview.LinkedListNode;

public class FindIntersectionOfTwoList {

    private static LinkedListNode findIntersectionNode(LinkedListNode list1, LinkedListNode list2) {
        int list1Size = size(list1);
        int list2Size = size(list2);

        LinkedListNode sorter = list1Size > list2Size ? list2 : list1;
        LinkedListNode longer = list1Size > list2Size ? list1 : list2;

        int lingthDiff = Math.abs(list1Size - list2Size);
        while (lingthDiff > 0) {
            longer = longer.getNext();
            lingthDiff--;
        }

        while (longer != sorter) {
            longer = longer.getNext();
            sorter = sorter.getNext();
        }

        return longer;

    }

    private static int size(LinkedListNode list) {
        int length = 0;
        while (list != null) {
            length++;
            list = list.getNext();
        }
        return length;

    }

    public static void main(String[] args) {
        LinkedListNode list1 = TestDataUtils.prepareLinkedListTestData();
        LinkedListNode list2 = new LinkedListNode(5);
        list2.setNext(new LinkedListNode(7));
        list2.getNext().setNext(list1.getNext().getNext().getNext());

        TestDataUtils.printListData(list1);
        TestDataUtils.printListData(list2);

        LinkedListNode interSectNode= findIntersectionNode(list1, list2);
        System.out.println(interSectNode!=null? interSectNode.getData() : "No Node Found");


    }
}

