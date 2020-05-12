package cracking.coding.interview.ch3;

public class ImplementingQueUsingTwoStack {
    Stack newStack, oldStack;

    public ImplementingQueUsingTwoStack(int capacity) {
        newStack = new Stack(capacity);
        oldStack = new Stack(capacity);
    }

    public int size() {
        return newStack.size() + oldStack.size();
    }

    public void add(int value) {
        newStack.push(value);
    }

    public void remove() {
        shiftStacks();
        oldStack.pop();
    }

    public void peek() {
        shiftStacks();
        oldStack.pop();
    }

    private void shiftStacks() {
        if (oldStack.isEmpty()) {
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }


        }
    }
}

class Stack {
    private int capacity;
    private int top;
    private int size;
    private int[] values;

    public Stack(int capacity) {
        values = new int[capacity];
        this.capacity = capacity;
    }

    public boolean push(int value) {
        if (size >= capacity) {
            return false;
        }
        values[top] = value;
        top++;
        size++;
        return true;
    }

    public int pop() {
        if (size == 0) {
            //Throw Exception
            return -1;
        } else {
            top--;
            int value = values[top];
            size--;

            return value;
        }
    }

    public int peek() {
        if (size == 0) {
            //Throw Exception
            return -1;
        } else {
            return values[top-1];
        }

    }

    public boolean isEmpty() {
        return this.size == 0;

    }

    public boolean isFull() {
        return this.size >= capacity;

    }

    public int size() {
        return this.size;

    }

}