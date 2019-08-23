public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        solution.generateMatrix(4);
    }

    public int[][] generateMatrix(int n) {
        int[][] board = new int[n][n];
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
        generateMatrixHelper(board, 0, 0, 0, dirs, 0);
        return board;
    }

    public void generateMatrixHelper(int[][] board, int x, int y, int depth, int[][] dirs, int dir) {
        if (depth >= board.length * board[0].length) {
            return;
        }
        board[x][y] = depth + 1;
        int nx = x + dirs[dir][0];
        int ny = y + dirs[dir][1];
        if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] != 0) {
            dir = (dir + 1) % 4;
            nx = x + dirs[dir][0];
            ny = y + dirs[dir][1];
        }
        generateMatrixHelper(board, nx, ny, depth + 1, dirs, dir);
    }
}
