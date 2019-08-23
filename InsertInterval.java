import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};
        solution.insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                merged.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                if (!inserted) {
                    merged.add(newInterval);
                    inserted = true;
                }
                merged.add(intervals[i]);
            } else {
                if (intervals[i][0] < newInterval[0]) {
                    newInterval[0] = intervals[i][0];
                }
                if (intervals[i][1] > newInterval[1]) {
                    newInterval[1] = intervals[i][1];
                    merged.add(newInterval);
                    inserted = true;
                }
            }
        }
        if (!inserted) {
            merged.add(newInterval);
        }
        int[][] result = new int[merged.size()][];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
