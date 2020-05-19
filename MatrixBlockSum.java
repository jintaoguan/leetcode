class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] rsum = new int[m][n];
        int[][] result = new int[m][n];

        // find range sum for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rsum[i][j] = mat[i][j];
                if (i - 1 >= 0 && j - 1 >= 0) {
                    rsum[i][j] += rsum[i][j - 1] + rsum[i - 1][j] - rsum[i - 1][j - 1];
                } else if (i - 1 >= 0) {
                    rsum[i][j] += rsum[i - 1][j];
                } else if (j - 1 >= 0) {
                    rsum[i][j] += rsum[i][j - 1];
                }
            }
        }

        // Compute matrix block sum using ppreviously computed range sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - K);
                int r2 = Math.min(m - 1, i + K);
                int c1 = Math.max(0, j - K);
                int c2 = Math.min(n - 1, j + K);

                result[i][j] = rsum[r2][c2];

                if (r1 - 1 >= 0 && c1 - 1 >= 0) {
                    result[i][j] = result[i][j] - rsum[r1 - 1][c2] - rsum[r2][c1 - 1] + rsum[r1 - 1][c1 - 1];
                } else if (r1 - 1 >= 0) {
                    result[i][j] -= rsum[r1 - 1][c2];
                } else if (c1 - 1 >= 0) {
                    result[i][j] -= rsum[r2][c1 - 1];
                }
            }
        }
        return result;
    }
}

