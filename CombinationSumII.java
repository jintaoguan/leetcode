import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = new int[]{10,1,2,7,6,1,5};
        System.out.println(solution.combinationSum2(nums, 8));
        nums = new int[]{2,5,2,1,2};
        System.out.println(solution.combinationSum2(nums, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, 0, current, result);
        return result;
    }

    public void combinationSum2Helper(int[] candidates, int target, int index, int sum,
                                     List<Integer> current, List<List<Integer>> result) {
        if (sum == target) {
            List<Integer> solution = new ArrayList<>(current);
            result.add(solution);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                // for every pick, we will not pick the same number twice
                // if we pick the same number again, it would generate same solution with the rest numbers
                continue;
            }
            if (sum + candidates[i] > target) {
                return;
            }
            current.add(candidates[i]);
            combinationSum2Helper(candidates, target,i + 1, sum + candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}
