import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> positions = new HashMap<>();
        int maxLength = 1;
        int startIndex = 0;
        int index = 0;
        while (index < s.length()) {
            if (!positions.containsKey(s.charAt(index))) {
                maxLength = Math.max(index - startIndex + 1, maxLength);
            } else {
                int endIndex = positions.get(s.charAt(index));
                while (startIndex <= endIndex) {
                    positions.remove(s.charAt(startIndex));
                    startIndex++;
                }
            }
            positions.put(s.charAt(index), index);
            index++;
        }
        return maxLength;
    }
}
