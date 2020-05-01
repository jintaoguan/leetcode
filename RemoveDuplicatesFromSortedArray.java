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
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[last]) {
                last++;
                nums[last] = nums[i];
            }
        }
        return last + 1;
    }
}
