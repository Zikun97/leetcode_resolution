package nromal;

public class Leetcode_0669 {

    /**
     * 题目：修建二叉树
     */
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            return dfs(root, low, high);
        }

        private TreeNode dfs(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (root.val < low) {
                return dfs(root.right, low, high);
            }

            if (root.val > high) {
                return dfs(root.left, low, high);
            }

            root.left = dfs(root.left, low, high);
            root.right = dfs(root.right, low, high);
            return root;
        }
    }
}
