public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(7, 3));
        System.out.println(solution.uniquePaths2(7, 3));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        int i = 0;
        long result = 1;
        int sum = m + n - 2;
        int p = Math.min(m, n);
        for(i = 0; i < p - 1; i++) {
            result = result * (sum - i) / (i + 1);
        }
        return (int)result;
    }
}
