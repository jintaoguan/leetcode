public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("bab"));
        System.out.println(solution.longestPalindrome("dvdf"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; ++i) {
            String palindrome = expand(s, i, i);
            if (palindrome.length() > res.length()) {
                res = palindrome;
            }
            palindrome = expand(s, i, i + 1);
            if (palindrome.length() > res.length()) {
                res = palindrome;
            }
        }
        return res;
    }
    private String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
