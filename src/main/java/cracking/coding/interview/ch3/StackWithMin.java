package cracking.coding.interview.ch3;

public class StackWithMin {
    private int capacity;
    private int top;
    private NodeWithMin[] values;
    public StackWithMin(int capacity){
        values= new NodeWithMin[capacity];
        this.capacity=capacity;
    }

    public void push(int value){
        if(top != capacity-1){
            int min =this.min();
            min = min > value ? value:min;
            values[top]= new NodeWithMin(value,min);
            top++;
        }

    }
    public int pop(){
        if(top==0){
            //Throw Exception
            return -1;
        }else{
            top--;
            int value = values[top].getValue();
            values[top]=null;

            return value;
        }
    }

    public int peek(){
        if(top==0){
            //Throw Exception
            return -1;
        }else{
            return values[top-1].getValue();
        }

    }
    public int min(){
        if(top==0){
            return Integer.MAX_VALUE;
        }
        return values[top-1].getMin();
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin =new StackWithMin(10);
        stackWithMin.push(5);
        System.out.println("Min ="+stackWithMin.min());

        stackWithMin.push(6);
        System.out.println("Min ="+stackWithMin.min());
        stackWithMin.push(3);
        System.out.println("Min ="+stackWithMin.min());
        stackWithMin.push(7);
        System.out.println("Min ="+stackWithMin.min());
        System.out.println("Pop ="+stackWithMin.pop());
        System.out.println("Min ="+stackWithMin.min());
        System.out.println("Pop ="+stackWithMin.pop());
        System.out.println("Min ="+stackWithMin.min());
        System.out.println("Pop ="+stackWithMin.pop());
        System.out.println("Min ="+stackWithMin.min());
    }

}

class NodeWithMin{
    private int value;
    private int min;

    NodeWithMin(int value,int min){
        this.value=value;
        this.min=min;
    }

    public int getValue() {
        return value;
    }

    public int getMin() {
        return min;
    }
}
