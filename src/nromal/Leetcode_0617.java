package nromal;

public class Leetcode_0617 {

    /**
     * 题目：合并二叉树
     */

    /**
     * 自己的想法，迭代
     * 效率不高
     */
    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }
            TreeNode node = new TreeNode(0);
            if (root1 != null) {
                node.val += root1.val;
            }
            if (root2 != null) {
                node.val += root2.val;
            }
            node.left = mergeTrees(root1 == null ? null: root1.left, root2 == null? null: root2.left);
            node.right = mergeTrees(root1 == null ? null: root1.left, root2 == null? null: root2.left);
            return node;
        }
    }


    class Solution0 {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            TreeNode node = new TreeNode(root1.val + root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
            return node;
        }
    }


}
