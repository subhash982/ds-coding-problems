package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List <List <Integer>> pascalTriangle = new LinkedList <>();
        if(numRows==0){
            return pascalTriangle;
        }
        //Add the forst Row
        pascalTriangle.add(new LinkedList <>());
        pascalTriangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List <Integer> prevRow = pascalTriangle.get(i-1);
            List <Integer> currRow = new LinkedList <>();
            currRow.add(1);

            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            currRow.add(1);
            pascalTriangle.add(currRow);
        }
        return pascalTriangle;
    }
}


