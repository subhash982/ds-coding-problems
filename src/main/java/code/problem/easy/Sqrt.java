package code.problem.easy;

public class Sqrt {
    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left+(right-left)/ 2;
            if(mid > x/mid){
                right =mid-1;
            }else if(mid <  x/mid){
                left= mid+1;
            }else{
                return mid;
            }
        }
        return right;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(5345345));
        System.out.println(Math.sqrt(5345345));
    }
}
