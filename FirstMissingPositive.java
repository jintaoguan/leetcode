public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1000};
        System.out.println(solution.firstMissingPositive(nums));
        nums = new int[]{1,2,0};
        System.out.println(solution.firstMissingPositive(nums));
        nums = new int[]{3,4,-1,1};
        System.out.println(solution.firstMissingPositive(nums));
        nums = new int[]{7,8,9,11,12};
        System.out.println(solution.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int index = 0;
        int n = nums.length;
        while (index < n) {
            if (nums[index] < 1 || nums[index] >= n || nums[index] == index + 1) {
                index++;
            } else if (nums[index] != index + 1) {
                if (nums[nums[index]-1] != nums[index]) {
                    int pos = nums[index] - 1;
                    int tmp = nums[index];
                    nums[index] = nums[pos];
                    nums[pos] = tmp;
                } else {
                    index++;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
