class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        System.out.println(solution.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        return isValidBSTHelper(root.left, min, root) && isValidBSTHelper(root.right, root, max);
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

