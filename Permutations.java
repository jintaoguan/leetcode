import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3};
        System.out.println(solution.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        permuteHelper(nums, 0, result);
        return result;
    }

    public void permuteHelper(int[] nums, int index, List<List<Integer>> result) {
        if (index >= nums.length) {
            List<Integer> solution = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                solution.add(nums[i]);
            }
            result.add(solution);
        } else {
            for (int i = index; i < nums.length; i++) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                permuteHelper(nums, index + 1, result);
                tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
