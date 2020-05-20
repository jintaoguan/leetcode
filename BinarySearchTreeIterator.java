import java.util.Stack;

class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        int ans = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }
        return ans;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
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
