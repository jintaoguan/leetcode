public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solution.solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] sqrs = new boolean[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int k = i / 3 * 3 + j / 3;
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                rows[i][num] = true;
                cols[j][num] = true;
                sqrs[k][num] = true;
            }
        }
        solveSudokuHelper(board, rows, cols, sqrs, 0, 0);
    }

    public boolean solveSudokuHelper(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] sqrs, int x, int y) {
        if (x >= 9) {
            return true;
        }
        int k = x / 3 * 3 + y / 3;
        int nx = x;
        int ny = y + 1;
        if (ny >= 9) {
            ny = 0;
            nx = nx + 1;
        }
        if (board[x][y] != '.') {
            return solveSudokuHelper(board, rows, cols, sqrs, nx, ny);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (rows[x][i] || cols[y][i] || sqrs[k][i]) {
                    continue;
                }
                rows[x][i] = true;
                cols[y][i] = true;
                sqrs[k][i] = true;
                board[x][y] = (char)(i + '0');
                boolean success = solveSudokuHelper(board, rows, cols, sqrs, nx, ny);
                if (success) {
                    return true;
                }
                board[x][y] = '.';
                rows[x][i] = false;
                cols[y][i] = false;
                sqrs[k][i] = false;
            }
        }
        return false;
    }
}
