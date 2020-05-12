package cracking.coding.interview.ch2;

import cracking.coding.interview.LinkedListNode;

public class SumLists {

    private static LinkedListNode sumTwoList(LinkedListNode node1, LinkedListNode node2){

        LinkedListNode header=null;
        LinkedListNode runnerNode=null;
        int cary=0;
        while(node1!=null && node2!=null){
            int sum =node1.getData()+node2.getData()+cary;
            if(header==null){
                header =new LinkedListNode(sum%10);
                runnerNode=header;
            }else{
                runnerNode.setNext(new LinkedListNode(sum%10));
                runnerNode=runnerNode.getNext();
            }

            cary=sum/10;
            node1=node1.getNext();
            node2=node2.getNext();

        }

        while (node1!=null){
            int sum =node1.getData()+cary;
            runnerNode.setNext(new LinkedListNode(sum%10));
            runnerNode=runnerNode.getNext();
            cary=sum/10;
            node1=node1.getNext();
        }

        while (node2!=null){
            int sum =node2.getData()+cary;
            runnerNode.setNext(new LinkedListNode(sum%10));
            runnerNode=runnerNode.getNext();
            cary=sum/10;
            node1=node2.getNext();
        }

        if(cary==1){

        }

        return header;


    }

    public static void main(String[] args) {
        LinkedListNode number1=TestDataUtils.getNumberOne();
        TestDataUtils.printListData(number1);
        LinkedListNode number2=TestDataUtils.getNumberTwo();
        TestDataUtils.printListData(number2);

        LinkedListNode sum = sumTwoList(number1,number2);
        TestDataUtils.printListData(sum);
    }
}
