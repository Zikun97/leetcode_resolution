package nromal;

public class Leetcode_0236 {

    /**
     * 题目描述： 二叉树的最近公共节点
     */

    class Solution {

        private TreeNode p;
        private TreeNode q;
        private TreeNode result;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.p = p;
            this.q = q;
            dfs(root);
            return result;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (result != null) {
                return 2;
            }
            int ans = 0;

            ans = dfs(root.left) + ans;
            ans += dfs(root.right);

            if (root == p || root == q) {
                ans += 1;
            }
            if (ans == 2) {
                // 这里双重检验，保证是最初的节点
                if (result == null) {
                    result = root;
                }
            }
            return ans;
        }

    }
}
