import java.awt.print.PrinterGraphics;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        int[] input2 = new int[]{1,1};
        System.out.println(solution.maxArea(input));
        System.out.println(solution.maxArea(input2));
    }

    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = 0;
        while (leftIndex < rightIndex) {
            int currentArea = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            maxArea = Math.max(maxArea, currentArea);
            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxArea;
    }
}
