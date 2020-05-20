class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(solution.isBalanced(root));
    }

    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedHelper(root);
        return balance;
    }

    public int isBalancedHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);
        if(Math.abs(left - right) > 1){
            balance = false;
            return 0;
        }
        return 1 + Math.max(left, right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

