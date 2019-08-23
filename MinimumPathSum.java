public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[][] grid = new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(solution.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
