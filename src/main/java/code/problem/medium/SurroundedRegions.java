package code.problem.medium;

/**
 * 130. Surrounded Regions
 * <p>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {

    public void solve(char[][] board) {

        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int columns = board[0].length;

        //Check Boundry Rows
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                boundryDFS(board, i, 0);
            }
            if (board[i][columns - 1] == 'O') {
                boundryDFS(board, i, columns - 1);
            }
        }
        //Check Boundry Column
        for (int j = 0; j < columns; j++) {
            if (board[0][j] == 'O') {
                boundryDFS(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                boundryDFS(board, rows - 1, j);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void boundryDFS(char[][] board, int row, int column) {
        if (row < 0 || row > board.length - 1 || column < 0 || column > board[row].length - 1) {
            return;
        }
        if (board[row][column] == 'O') {
            board[row][column] = '*';
        }
        if (row > 0 && board[row - 1][column] == 'O') {
            boundryDFS(board, row - 1, column);
        }

        if (row < board.length - 1 && board[row + 1][column] == 'O') {
            boundryDFS(board, row + 1, column);
        }

        if (column > 0 && board[row][column - 1] == 'O') {
            boundryDFS(board, row, column - 1);
        }

        if (column < board[0].length - 1 && board[row][column + 1] == 'O') {
            boundryDFS(board, row, column + 1);
        }
    }
}
