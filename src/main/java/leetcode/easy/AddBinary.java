package leetcode.easy;

public class AddBinary {

    public static String addBinary(String a, String b) {
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;

        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int sum = carry;
            if (l1 >= 0) sum += a.charAt(l1) - '0';
            if (l2 >= 0) sum += b.charAt(l2) - '0';
            builder.append(sum % 2);
            carry = sum / 2;
            l1--;
            l2--;
        }
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
