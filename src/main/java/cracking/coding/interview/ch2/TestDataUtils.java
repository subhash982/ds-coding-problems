package cracking.coding.interview.ch2;

import cracking.coding.interview.LinkedListNode;

public class TestDataUtils {

    public static LinkedListNode prepareLinkedListTestData(){
        LinkedListNode header = new LinkedListNode(6);
        header.setNext(new LinkedListNode(7));
        LinkedListNode currNode= header.getNext();
        currNode.setNext(new LinkedListNode(9));
        currNode =currNode.getNext();

        currNode.setNext(new LinkedListNode(56));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(9));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(23));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(10));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(10));
        currNode =currNode.getNext();

        return header;
    }

    public static LinkedListNode prepareCircularLinkedListTestData(){
        LinkedListNode header = new LinkedListNode(6);
        header.setNext(new LinkedListNode(7));
        LinkedListNode currNode= header.getNext();
        currNode.setNext(new LinkedListNode(9));
        currNode =currNode.getNext();

        currNode.setNext(new LinkedListNode(56));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(9));
        LinkedListNode circulatNode=currNode;
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(23));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(10));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(10));
        currNode =currNode.getNext();
        currNode.setNext(circulatNode);

        return header;
    }
    public static void printListData(LinkedListNode node){

        while(node!=null){
            System.out.print(node.getData()+"=>");
            node=node.getNext();
        }
        System.out.println("");

    }

    public static LinkedListNode getNumberOne(){
        LinkedListNode header = new LinkedListNode(1);
        header.setNext(new LinkedListNode(1));
        LinkedListNode currNode= header.getNext();
        currNode.setNext(new LinkedListNode(1));


        return header;
    }

    public static LinkedListNode getNumberTwo(){
        LinkedListNode header = new LinkedListNode(6);
        header.setNext(new LinkedListNode(7));
        LinkedListNode currNode= header.getNext();
        currNode.setNext(new LinkedListNode(9));

        return header;
    }

    public static LinkedListNode getPalindromList(){
        LinkedListNode header = new LinkedListNode(5);
        header.setNext(new LinkedListNode(6));
        LinkedListNode currNode= header.getNext();
        currNode.setNext(new LinkedListNode(7));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(8));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(7));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(6));
        currNode =currNode.getNext();
        currNode.setNext(new LinkedListNode(5));

        return header;
    }
}
