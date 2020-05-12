package cracking.coding.interview.ch16;

public class NumberSwapper {

    public static void main(String[] args) {

        //Using Addition
        int a=9,b=5;
        System.out.println("Before Swap [a="+a+",b="+b+"]");
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("After Swap [a="+a+",b="+b+"]");
        //Rest the values
        a=9;
        b=5;
        //Using Logical operation
        System.out.println("Before Swap [a="+a+",b="+b+"]");
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("After Swap [a="+a+",b="+b+"]");
    }
}
