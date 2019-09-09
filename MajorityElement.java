public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{3,2,3};
        System.out.println(solution.majorityElement(nums1));
        int[] nums2 = new int[]{2,2,1,1,1,2,2};
        System.out.println(solution.majorityElement(nums2));
    }

    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = nums[i];
                    count = 1;
                }
            }
        }
        return majority;
    }
}
