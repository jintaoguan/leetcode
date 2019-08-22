public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        for (int i = 1; i < 10; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }

    public String countAndSay(int n) {
        String seq = new String("1X");
        for (int i = 1; i < n; i++) {
            seq = generateNewSeq(seq);
        }
        return seq.substring(0, seq.length() - 1);
    }

    public String generateNewSeq(String seq){
        StringBuilder newSeq = new StringBuilder();
        int num = 1;
        for (int i = 0; i < seq.length() - 1; i++) {
            if (seq.charAt(i) != seq.charAt(i+1)){
                newSeq.append(num).append(seq.charAt(i));
                num = 1;
            } else {
                num++;
            }
        }
        newSeq.append("X");
        return newSeq.toString();
    }
}
