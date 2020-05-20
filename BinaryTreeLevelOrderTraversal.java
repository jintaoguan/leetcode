import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] argc) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        System.out.println(solution.levelOrder(t1));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> nextLevelQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    nextLevelQueue.add(node.left);
                }
                if (node.right != null) {
                    nextLevelQueue.add(node.right);
                }
            }
            queue = nextLevelQueue;
            ans.add(level);
        }
        return ans;
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

