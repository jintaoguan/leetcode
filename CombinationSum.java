import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,3,6,7};
        System.out.println(solution.combinationSum(nums, 7));
        nums = new int[]{2,3,5};
        System.out.println(solution.combinationSum(nums, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, 0, current, result);
        return result;
    }

    public void combinationSumHelper(int[] candidates, int target, int index, int sum,
                                     List<Integer> current, List<List<Integer>> result) {
        if (sum == target) {
            List<Integer> solution = new ArrayList<>(current);
            result.add(solution);
        } else {
            for (int i = index; i < candidates.length; i++) {
                int nextSum = sum + candidates[i];
                if (nextSum > target) {
                    continue;
                }
                current.add(candidates[i]);
                combinationSumHelper(candidates, target, i, nextSum, current, result);
                current.remove(current.size() - 1);
            }
        }

    }
}
