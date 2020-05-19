class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(solution.matrixScore(nums));
    }

    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (countColOne(A, m, j) < (m + 1) / 2) {
                flipCol(A, m, j);
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp *= 2;
                tmp += A[i][j];
            }
            sum += tmp;
        }
        return sum;
    }

    public int countColOne(int[][] A, int m, int col) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (A[i][col] == 1) {
                cnt++;
            }
        }
        return cnt;
    }

    public void flipCol(int[][] A, int m, int col) {
        for (int i = 0; i < m; i++) {
            A[i][col] = 1 - A[i][col];
        }
    }
}

