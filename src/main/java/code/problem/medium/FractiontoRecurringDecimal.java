package code.problem.medium;

import java.util.HashMap;

/**
 * 166. Fraction to Recurring Decimal
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 Example 1:

 Input: numerator = 1, denominator = 2
 Output: "0.5"
 Example 2:

 Input: numerator = 2, denominator = 1
 Output: "2"
 Example 3:

 Input: numerator = 2, denominator = 3
 Output: "0.(6)"
 */
public class FractiontoRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        String result = "";

        // is result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }

        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient
        long res = num / den;
        result += String.valueOf(res);

        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        // right-hand side of decimal point
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while (remainder != 0) {
            System.out.println(remainder);
            // if digits repeat
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }

            // continue
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(fractionToDecimal(22,7));
    }
}
