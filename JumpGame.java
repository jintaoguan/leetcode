public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = new int[] {2,3,1,1,4};
        System.out.println(solution.canJump(nums));
        nums = new int[] {3,2,1,0,4};
        System.out.println(solution.canJump(nums));
        nums = new int[] {1, 2, 3};
        System.out.println(solution.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int max = nums[0];
        int cur = 0;
        while (cur <= max) {
            max = Math.max(max, cur + nums[cur]);
            if (max >= nums.length - 1) {
                return true;
            }
            cur++;
        }
        return false;
    }
}
