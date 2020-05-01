class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode ans = getTargetCopy(original.left, cloned.left, target);
        if (ans != null) {
            return ans;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }
}
