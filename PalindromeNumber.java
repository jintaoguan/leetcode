public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(1000021));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int magitude = 1;
        while (num / magitude >= 10) {
            magitude = magitude * 10;
        }
        while (x != 0) {
            int rightDigit = x % 10;
            int leftDigit = x / magitude;
            if (rightDigit != leftDigit) {
                return false;
            }
            x = (x % magitude) / 10;
            magitude = magitude / 100;
        }
        return true;
    }
}
