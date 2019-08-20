import java.util.Stack;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (ch == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (ch == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
