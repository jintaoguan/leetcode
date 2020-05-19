iclass Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays(nums, 3));
    }

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
}

