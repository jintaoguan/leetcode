import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2, 2};
        System.out.println(solution.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(nums, visited, permutation, result);
        return result;
    }

    public void permuteUniqueHelper(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() >= nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // if number is the same as the previous one and not visted
	    // it means we have used the the element before
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            permuteUniqueHelper(nums, visited, permutation, result);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
