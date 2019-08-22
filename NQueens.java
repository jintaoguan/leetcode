import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queen = new int[n];
        solveNQueensHelper(queen, 0, result);
        return result;
    }

    public void solveNQueensHelper(int[] queen, int x, List<List<String>> result) {
        if (x >= queen.length) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < queen.length; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < queen.length; ++j) {
                    if (queen[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }
        for (int i = 0; i < queen.length; i++) {
            // check this position (x, i) is legal
            boolean legal = true;
            for (int j = 0; j < x; j++) {
                if (queen[j] == i || Math.abs(queen[j] - i) == Math.abs(x - j)) {
                    legal = false;
                }
            }
            if (!legal) {
                continue;
            }
            queen[x] = i;
            solveNQueensHelper(queen, x + 1, result);
        }
    }
}
