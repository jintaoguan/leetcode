public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution.removeDuplicates(nums1));
        System.out.println(solution.removeDuplicates(nums2));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int index = 1;
        int cur = 1;
        int lastNum = nums[0];
        while (cur < nums.length) {
            if (nums[cur] != lastNum) {
                nums[index] = nums[cur];
                lastNum = nums[cur];
                index++;
            }
            cur++;
        }
        return index;
    }
}
