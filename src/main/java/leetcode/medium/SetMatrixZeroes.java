package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

 Example 1:

 Input:
 [
 [1,1,1],
 [1,0,1],
 [1,1,1]
 ]
 Output:
 [
 [1,0,1],
 [0,0,0],
 [1,0,1]
 ]
 Example 2:

 Input:
 [
 [0,1,2,0],
 [3,4,5,2],
 [1,3,1,5]
 ]
 Output:
 [
 [0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]
 ]
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet <>();
        Set<Integer> cols = new HashSet<>();
        for (int i=0;i < matrix.length;i++){
            for (int j=0;j < matrix[i].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }

        }

        //Set All the Row to zero
        for(int currRow : rows){
            for(int i=0; i < matrix[0].length;i++)
            matrix[currRow][i]=0;
        }
        //Set All the Column to zero
        for(int currCol : cols){
            for(int i=0; i < matrix.length;i++)
                matrix[i][currCol]=0;
        }
    }
}
