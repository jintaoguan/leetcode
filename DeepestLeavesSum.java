class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int depth = getDepth(root);
        return deepestLeavesSum(root, 1, depth);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int deepestLeavesSum(TreeNode root, int depth, int deepest) {
        if (root == null) {
            return 0;
        }
        if (depth == deepest) {
            return root.val;
        }
        return deepestLeavesSum(root.left, depth + 1, deepest) + deepestLeavesSum(root.right, depth + 1, deepest);
    }
}
