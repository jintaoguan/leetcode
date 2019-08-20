import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 26);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (positions.containsKey(target - nums[i])) {
                return new int[]{positions.get(target - nums[i]), i};
            }
            positions.put(nums[i],i);
        }
        return null;
    }
}
