package cracking.coding.interview.ch3;

public class ThreeInOneStack {
    private int numberOfStack=3;
    private int stackCapacity;
    private int[] values;
    protected int[] sizes;

    public ThreeInOneStack(int stackSize){
        stackCapacity = stackSize;
        values=new int[numberOfStack*stackSize];
        sizes=new int[numberOfStack];
    }

    public void push(int stackNum, int value){
        if(isStackFull(stackNum)){
            //Throw exception
        }else{
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] =value;
        }


    }

    public int pop(int stackNum){
        if(isEmpty(stackNum)){
            //Throw Exception
        }

        int topIndex =indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] =0;
        sizes[stackNum]--;
        return value;

    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            //Throw Exception
        }
        return values[indexOfTop(stackNum)];
    }

    private boolean isStackFull(int stackNum){
        return sizes[stackNum] ==stackCapacity;

    }

    private boolean isEmpty(int stackNum){
        return sizes[stackNum] ==0;

    }
    private int indexOfTop(int stackNum){
        int offset = stackNum*stackCapacity;
        int size = sizes[stackNum];
        return offset+size-1;

    }

    public static void main(String[] args) {
        ThreeInOneStack multiStack=new ThreeInOneStack(10);
        multiStack.push(0,23);
        multiStack.push(0,10);

        System.out.println(multiStack.pop(0));
        System.out.println(multiStack.pop(0));
        System.out.println(multiStack.pop(0));
    }
}


