package cracking.coding.interview.ch3;

public class StackWithSortingFeature {

    /**
     * Sort the stack using the another stack
     * @param stack
     */
    public static void sort(Stack stack) {
        Stack tempStack = new Stack(stack.size() + 1);
        while (!stack.isEmpty()) {
            int topElement = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > topElement) {
                stack.push(tempStack.pop());
            }
            tempStack.push(topElement);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());

        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(19);
        stack.push(11);
        stack.push(20);
        stack.push(29);
        stack.push(9);

        sort(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
