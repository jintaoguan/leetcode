public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2,3,1};
        System.out.println(solution.rob(nums1));
        int[] nums2 = new int[]{2,7,9,3,1};
        System.out.println(solution.rob(nums2));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
