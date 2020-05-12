package code.problem.easy;

public class PlusOneToNumberInArray {
    public int[] plusOne(int[] digits) {
        boolean isAllDigitNine = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                isAllDigitNine = false;
                break;
            }
        }
        if (isAllDigitNine) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        } else {

            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] + 1 > 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i] + 1;
                    return digits;
                }

            }
        }
        return digits;
    }

    public static void main(String[] args) {

    }
}
