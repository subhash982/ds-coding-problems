package cracking.coding.interview.ch2;

import cracking.coding.interview.LinkedListNode;

import java.util.List;
import java.util.Stack;

public class CheckLinkedListPalindrome {

    private static boolean isListPalindrom(LinkedListNode node){
        LinkedListNode reverse=null;
        LinkedListNode header=node;
        while(node!=null){
            LinkedListNode newNode=null;
            if(reverse==null){
                newNode=new LinkedListNode(node.getData());
                reverse = newNode;
            }else{
                newNode=new LinkedListNode(node.getData());
                newNode.setNext(reverse);
                reverse=newNode;

            }
            node=node.getNext();

        }

        while(header!=null && reverse!=null){
            if(header.getData()!=reverse.getData()){
                return false;
            }
            header=header.getNext();
            reverse=reverse.getNext();
        }
        return true;

    }

    private static boolean isListPalindromUsingStack(LinkedListNode node){
        LinkedListNode slowPointer =node;
        LinkedListNode fastPointer =node;
        Stack<Integer> cache=new Stack <>();

        while(fastPointer!=null && fastPointer.getNext()!=null){
            cache.push(slowPointer.getData());
            slowPointer=slowPointer.getNext();
            fastPointer=fastPointer.getNext().getNext();
        }
        //has the odd number of elements , skip tje middle element
        if(fastPointer!=null){
            slowPointer=slowPointer.getNext();
        }
        while(slowPointer!=null){
            if(slowPointer.getData()!=cache.pop()){
                return false;
            }
            slowPointer=slowPointer.getNext();
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isListPalindrom(TestDataUtils.getPalindromList()));
        System.out.println(isListPalindrom(TestDataUtils.prepareLinkedListTestData()));

        System.out.println(isListPalindromUsingStack(TestDataUtils.getPalindromList()));
        System.out.println(isListPalindromUsingStack(TestDataUtils.prepareLinkedListTestData()));
    }

}
