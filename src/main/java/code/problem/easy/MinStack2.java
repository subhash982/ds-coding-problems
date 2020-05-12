package code.problem.easy;
/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.


 Example:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class MinStack2 {
    public Node top;

    /** initialize your data structure here. */
    public MinStack2() {

    }

    public void push(int x) {
        if(top == null){
            top = new Node(x, x);
        }else{
            Node e = new Node(x, Math.min(x,top.min));
            e.next = top;
            top = e;
        }

    }

    public void pop() {
        if(top == null)
            return;
        Node temp = top.next;
        top.next = null;
        top = temp;

    }

    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }

    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }

    class Node{
        public int value;
        public int min;
        public Node next;

        public Node(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
}
