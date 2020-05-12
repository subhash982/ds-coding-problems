package cracking.coding.interview.ch3;

import java.util.ArrayList;

public class SetOfStacks {
    private int capacity = 10;
    ArrayList <StackWithTopAndBottom> stacks = new ArrayList <>();

    public boolean push(int value) {
        StackWithTopAndBottom listStack = getLastStack();
        if (listStack != null && !listStack.isfull()) {
            listStack.push(value);
        } else {
            StackWithTopAndBottom stack = new StackWithTopAndBottom(this.capacity);
            stack.push(value);
            stacks.add(stack);
        }
        return true;
    }

    public int pop() {
        StackWithTopAndBottom listStack = getLastStack();
        if(listStack!=null){
            int v = listStack.pop();
            if(listStack.isEmptry()){
                stacks.remove(stacks.size()-1);
            }
            return v;
        }
        return -1;
    }

    public int popAt(int index) {
        return leftShift(index,true);
    }

    private int leftShift(int index,boolean removeTop){
        StackWithTopAndBottom stack =stacks.get(index);
        int removedItem;
        if(removeTop){
            removedItem =stack.pop();
        }else{
            removedItem=stack.removeBottom();
        }
        if(stack.isEmptry()){
            stacks.remove(index);
        }else if(stacks.size() > index+1){
           int v = leftShift(index, false);
            stack.push(v);
        }
        return removedItem;
    }


    private StackWithTopAndBottom getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

}


class StackWithTopAndBottom {
    private int capacity;
    private Node top, bottom;
    int size;

    public StackWithTopAndBottom(int capacity) {
        this.capacity = capacity;
    }

    public boolean push(int value) {
        if (size >= capacity)
            return false;

        size++;
        Node node = new Node(value);
        if (size == 1) {
            bottom = node;
        }
        join(node, top);
        top = node;
        return true;
    }

    public int pop() {
        Node t = top;
        top = top.below;
        size--;
        return t.value;
    }

    public int peek() {
        Node t = top;
        top = top.below;
        return t.value;

    }

    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) {
            bottom.below = null;
        }
        size--;
        return b.value;
    }

    public boolean isEmptry() {
        return size == 0;

    }

    public boolean isfull() {
        return size == capacity;

    }

    private void join(Node above, Node below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    class Node {
        public int value;
        public Node above, below;

        public Node(int value) {
            this.value = value;
        }
    }
}


