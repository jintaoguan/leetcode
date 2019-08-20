import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        List<String> ans = solution.letterCombinations("23");
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Integer, String> dict = new HashMap<>();
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");
        StringBuilder current = new StringBuilder();
        letterCombinationsHelper(digits, 0, dict, current, result);
        return result;
    }

    public void letterCombinationsHelper(String digit, int index, Map<Integer, String> dict,
                                         StringBuilder current, List<String> result) {
        if (index >= digit.length()) {
            result.add(current.toString());
        } else {
            int number = digit.charAt(index) - '0';
            String candidates = dict.get(number);
            for (int i = 0; i < candidates.length(); i++) {
                current.append(candidates.charAt(i));
                letterCombinationsHelper(digit, index + 1, dict, current, result);
                current.deleteCharAt(index);
            }
        }
    }
}
