class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) {
            if (removeLeafNodes(root.left, target) == null) {
                root.left = null;
            }
        }
        if (root.right != null) {
            if (removeLeafNodes(root.right, target) == null) {
                root.right = null;
            }
        }
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
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

