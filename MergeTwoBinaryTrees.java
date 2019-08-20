public class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        System.out.println(solution.mergeTrees(t1, t2));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
