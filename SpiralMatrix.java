import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solution.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        spiralOrderHelper(matrix, 0, 0, visited, dirs, 0, result);
        return result;
    }

    public void spiralOrderHelper(int[][] matrix, int x, int y, boolean[][] visited,
                                  int[][] dirs, int dir, List<Integer> result) {
        if (result.size() >= matrix.length * matrix[0].length) {
            return;
        }
        result.add(matrix[x][y]);
        visited[x][y] = true;
        int nx = x + dirs[dir][0];
        int ny = y + dirs[dir][1];
        if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || visited[nx][ny]) {
            dir = (dir + 1) % 4;
            nx = x + dirs[dir][0];
            ny = y + dirs[dir][1];
        }
        spiralOrderHelper(matrix, nx, ny, visited, dirs, dir, result);
    }
}
