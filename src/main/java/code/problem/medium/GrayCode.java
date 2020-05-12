package code.problem.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 * <p>
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 */
public class GrayCode {
    public List <Integer> grayCode(int n) {

        ArrayList <String> result = new ArrayList <String>();
        if (n == 0) {
            result.add("0");
        } else {
            result = new ArrayList <String>();

            // Add one bit pattern
            result.add("0");
            result.add("1");

            //2*n binary code can be generated from n digit bit
            int i, j;
            for (i = 2; i < (1 << n); i = i << 1) {
                //For each iteration double the number and then add 0 and 1 in front
                //Double the number
                for (j = i - 1; j >= 0; j--)
                    result.add(result.get(j));

                // append 0 to the first half
                for (j = 0; j < i; j++)
                    result.set(j, "0" + result.get(j));

                // append 1 to the second half
                for (j = i; j < 2 * i; j++)
                    result.set(j, "1" + result.get(j));
            }
        }


        ArrayList <Integer> finalOutput = new ArrayList <Integer>();
        for (String currNumber : result) {
            finalOutput.add(Integer.parseInt(currNumber, 2));
        }
        return finalOutput;
    }
}
