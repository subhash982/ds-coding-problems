package code.problem.easy;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String s = "1";
        while (n > 1) {
            StringBuilder builder = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                int count = 1;
                char ch =s.charAt(i);
                while (i + 1 < s.length() && ch == s.charAt(i + 1)) {
                    i++;
                    count++;
                }
                builder.append(count).append(ch);
                i++;
            }
            s = builder.toString();
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
