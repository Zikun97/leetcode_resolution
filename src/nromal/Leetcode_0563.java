package nromal;

public class Leetcode_0563 {

    class Solution {
        private int sum = 0;
        public int findTilt(TreeNode root) {
            dfs(root);
            return sum;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = dfs(node.left);
            int right = dfs(node.right);

            sum += Math.abs(right - left);
            return left + right + node.val;
        }
    }
}