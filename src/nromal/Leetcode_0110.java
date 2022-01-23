package nromal;

public class Leetcode_0110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    static class Solution {
        private boolean flag = true;
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int right = dfs(node.right);
            if (right == -1) {
                return -1;
            }
            int left = dfs(node.left);
            if (left == -1) {
                return -1;
            }
            if (Math.abs(right - left) > 1) {
                return -1;
            }
            return 1 + Math.max(right, left);
        }
    }
}
