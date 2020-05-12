package code.problem.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * Example:
 * Pascal Triangle
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * Input: 3
 * Output: [1,3,3,1]
 */
public class PascalTriangleII {
    public List <Integer> getRow(int rowIndex) {

        List <List <Integer>> pascalTriangle = new ArrayList <>();

        List <Integer> currRow = new ArrayList <>();
        currRow.add(1);

        pascalTriangle.add(currRow);
        for (int i = 1; i <= rowIndex; i++) {
            List <Integer> prevRow = pascalTriangle.get(i - 1);
            currRow = new LinkedList <>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            pascalTriangle.add(currRow);
        }
        return currRow;
    }
}
