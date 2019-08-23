import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(solution.merge(nums));
        nums = new int[][]{{1,4},{4,5}};
        System.out.println(solution.merge(nums));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new java.util.Comparator<int[]> (){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });
        List<int[]> merged = new ArrayList<>();
        int last = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= intervals[last][1]) {
                continue;
            }
            if (intervals[i][0] > intervals[last][1]) {
                merged.add(intervals[last]);
                last = i;
            } else {
                intervals[last][1] = intervals[i][1];
            }
        }
        merged.add(intervals[last]);
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
