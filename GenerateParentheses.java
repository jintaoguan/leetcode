import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        StringBuilder current = new StringBuilder();
        generateParenthesisHelper(n * 2, 0, 0, current, result);
        return result;
    }

    public void generateParenthesisHelper(int length, int index, int open,
                                          StringBuilder current, List<String> result) {
        if (index >= length) {
            if (open == 0) {
                result.add(current.toString());
            }
            return;
        }
        if (open < length / 2) {
            current.append('(');
            generateParenthesisHelper(length, index + 1, open + 1, current, result);
            current.deleteCharAt(index);
        }
        if (open > 0) {
            current.append(')');
            generateParenthesisHelper(length, index + 1, open - 1, current, result);
            current.deleteCharAt(index);
        }
    }
}
