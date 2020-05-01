class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{2, 3,1};
        solution.nextPermutation(nums1);
        System.out.println(nums1);
    }

    public void nextPermutation(int[] num) {
        if (num == null || num.length < 2) {
            return;
        }
        int len = num.length;
        int peak = len - 1;
        // num[i] is the peak
        while (peak >= 1 && num[peak] <= num[peak-1]) {
            peak--;
        }
        // descending order
        if (peak == 0) {
            int left = 0;
            int right = len - 1;
            while( left <= right ) {
                int tmp = num[left];
                num[left] = num[right];
                num[right] = tmp;
                left++;
                right--;
            }
            return;
        }
        int swap1 = peak - 1;
        int swap2 = num.length - 1;
        for (int i = num.length - 1; i >= peak; i--) {
            if (num[i] > num[swap1]) {
                swap2 = i;
                break;
            }
        }
        int tmp = num[swap1];
        num[swap1] = num[swap2];
        num[swap2] = tmp;
        int left = peak;
        int right = num.length - 1;
        while (left < right) {
            tmp = num[left];
            num[left] = num[right];
            num[right] = tmp;
            left++;
            right--;
        }
    }
}
