class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays(nums, 3));
    }

    // DFS solution
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWaysHelper(nums, 0, S);
    }

    public int findTargetSumWaysHelper(int[] nums, int index, int sum) {
        if (index >= nums.length) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int include = findTargetSumWaysHelper(nums, index + 1, sum - nums[index]);
        int exclude = findTargetSumWaysHelper(nums, index + 1, sum + nums[index]);
        return include + exclude;
    }

    // DP solution
    public int findTargetSumWaysDP(int[] nums, int S) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max += nums[i];
        }
        int k = max - S;
        if (k % 2 != 0 || k < 0) {
            return 0;
        }
        k /= 2;
        if (k > max) {
            return 0;
        }
        int[] dp = new int[k + 1];
        dp[0] = 1;
        if (nums[0] <= k) {
            dp[nums[0]] += 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[k];
    }
}

