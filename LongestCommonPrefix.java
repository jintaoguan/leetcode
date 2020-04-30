public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        for (int i = 0; i < len; ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (i >= strs[j].length()) {
                    return strs[0].substring(0, i);
                }
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
