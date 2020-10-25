package leetcode.easy;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result = result * 26 + (c - 'A') + 1;
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(titleToNumber("ZY"));
    }
}
