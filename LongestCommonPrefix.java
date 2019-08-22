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
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        boolean fail = false;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (ch != strs[j].charAt(i)) {
                    fail = true;
                    break;
                }
            }
            if (fail) {
                break;
            } else {
                prefix.append(ch);
            }
        }
        return prefix.toString();
    }
}
