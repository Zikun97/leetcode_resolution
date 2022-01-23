package nromal;

public class Leetcode_0222 {

    static class TreeNode {
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
        private int count;
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return count;
        }

        private void dfs(TreeNode root) {
            if (root != null) {
                this.count++;
            } else {
                return;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }
}
