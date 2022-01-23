package nromal;

public class Leetcode_0538 {

    /**
     * 题目：累加树
     */

    static class Solution {
        public TreeNode convertBST(TreeNode root) {
            dfs(root, 0);
            return root;
        }

        private int dfs(TreeNode root, int rightValue) {
            if (root == null) {
                return rightValue;
            }

            int right = dfs(root.right, rightValue);
            root.val  += right + rightValue;

            int left = dfs(root.left, root.val);
            return left;
        }
    }
}
