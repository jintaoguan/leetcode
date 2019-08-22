public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{3,2,2,3};
        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(solution.removeElement(nums1, 2));
        System.out.println(solution.removeElement(nums2, 2));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        int cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != val) {
                nums[index] = nums[cur];
                index++;
            }
            cur++;
        }
        return index;
    }
}
