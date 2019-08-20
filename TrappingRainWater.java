public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] height = new int[]{2, 0, 2};
        System.out.println(solution.trap(height));
    }

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > height[i]) {
                sum = sum + minHeight - height[i];
            }
        }
        return sum;
    }
}
