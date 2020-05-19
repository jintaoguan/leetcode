class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
    }

    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, null);
    }

    public int helper(TreeNode parent, TreeNode grandParent) {
        if (parent == null) {
            return 0;
        }
        int lsum = helper(parent.left, parent);
        int rsum = helper(parent.right, parent);
        if (grandParent != null) {
            if (grandParent.val % 2 == 0) {
                if (parent.left != null) {
                    lsum += parent.left.val;
                }
                if (parent.right != null) {
                    rsum += parent.right.val;
                }
            }
        }
        return lsum + rsum;
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

