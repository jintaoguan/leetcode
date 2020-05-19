import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(solution.findAndReplacePattern(words, pattern));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> wordToPattern = new HashMap<>();
            Map<Character, Character> patternToWord = new HashMap<>();
            boolean success = true;
            for (int i = 0; i < word.length(); i++) {
                char wordChar = word.charAt(i);
                char patternChar = pattern.charAt(i);
                if (!wordToPattern.containsKey(word.charAt(i)) && !patternToWord.containsKey(pattern.charAt(i))) {
                    wordToPattern.put(wordChar, patternChar);
                    patternToWord.put(patternChar, wordChar);
                } else if (wordToPattern.containsKey(wordChar) && wordToPattern.get(wordChar) != patternChar) {
                    success = false;
                    break;
                } else if (patternToWord.containsKey(patternChar) && patternToWord.get(patternChar) != wordChar) {
                    success = false;
                    break;
                }
            }
            if (success) {
                ans.add(word);
            }
        }
        return ans;
    }
}

