public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
    }

    public int reverse(int x) {
        long result = 0;
        long flag = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            result = result * 10 + digit;
        }
        result = result * flag;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)(result);
    }
}
