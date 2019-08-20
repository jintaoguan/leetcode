import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> writers = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            writers.add(new StringBuilder());
        }
        int index = 0;
        int dir = 1;
        for (int i = 0; i < s.length(); i++) {
            writers.get(index).append(s.charAt(i));
            index += dir;
            if (index == 0 || index == numRows - 1) {
                dir = -dir;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(writers.get(i).toString());
        }
        return result.toString();
    }
}
