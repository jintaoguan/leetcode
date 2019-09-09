import java.util.Stack;

public class Solution {
    public static void main(String[] argc) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }

    private static class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> stack;
        Stack<Integer> mins;

        public MinStack() {
            stack = new Stack<>();
            mins = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (mins.isEmpty() || x <= mins.peek()) {
                mins.push(x);
            }
        }

        public void pop() {
            int current = stack.pop();
            if (current == mins.peek()) {
                mins.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }
}
