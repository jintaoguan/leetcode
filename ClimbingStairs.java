class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        for (int i = 3; i <= n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}

