class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(solution.pathSum(root, 2));
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumHelper(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSumHelper(TreeNode root, int sum, int curSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        curSum += root.val;
        if (curSum == sum) {
            count++;
        }
        count += pathSumHelper(root.left, sum, curSum);
        count += pathSumHelper(root.right, sum, curSum);
        return count;
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

