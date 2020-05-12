package leetcode.medium;

/**
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class WordSearch {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && searchWord(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchWord(int row, int col, int index, String word, char[][] board) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || word.charAt(index) != board[row][col] ||  visited[row][col] ) {
            return false;
        }

        visited[row][col] = true;
        if (searchWord(row + 1, col, index + 1, word, board) ||
                searchWord(row - 1, col, index + 1, word, board) ||
                searchWord(row, col + 1, index + 1, word, board) ||
                searchWord(row, col - 1, index + 1, word, board)) {
            return true;
        }
//        visited[row][col] = false;
        return false;
    }
}
