class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        String s = "()))((";
        System.out.println(solution.minAddToMakeValid(s));
    }

    public int minAddToMakeValid(String S) {
        int count = 0;
        int open = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open >= 1) {
                    open--;
                } else {
                    count++;
                }
            }
        }
        count += open;
        return count;
    }
}

