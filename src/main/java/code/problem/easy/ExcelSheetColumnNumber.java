package code.problem.easy;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result = result * 26 + (c - 'A') + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(titleToNumber("ZY"));
    }
}
