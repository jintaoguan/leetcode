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
        System.out.println(solution.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] squares = new boolean[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                int k = i/3*3 + j/3;
                if (rows[i][num] || cols[j][num] || squares[k][num]) {
                    return false;
                }
                rows[i][num] = true;
                cols[j][num] = true;
                squares[k][num] = true;
            }
        }
        return true;
    }
}
