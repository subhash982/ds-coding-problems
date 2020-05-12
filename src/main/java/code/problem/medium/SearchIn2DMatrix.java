package code.problem.medium;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        while (row < matrix.length) {
            if (target >= matrix[row][0] && target <= matrix[row][matrix[0].length - 1]) {
                for (int i = 0; i < matrix[row].length; i++) {
                    if (target == matrix[row][i]) {
                        return true;
                    }
                }
                return false;
            }
            row++;
        }
        return false;
    }

    public boolean searchMatrixUsingBinarySearch(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        int left = 0;
        int right = row * column - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / column][mid % column];
            if (midElement == target) {
                return true;
            } else if (target < midElement) {
                right = mid - 1;
            } else if (target > midElement) {
                left = mid + 1;
            }

        }
        return false;
    }

}
