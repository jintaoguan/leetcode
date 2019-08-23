public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord(" "));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] splits = s.split(" ");
        if (splits.length == 0) {
            return 0;
        }
        return splits[splits.length - 1].length();
    }
}
