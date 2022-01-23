package nromal;

public class Leetcode_0701 {

    /**
     * 问题: 二叉搜索树插入问题
     */
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            // 注意输入条件
            if (root == null) {
                return new TreeNode(val);
            }
            TreeNode temp = root;
            TreeNode save = root;
            while (true) {
                if (temp == null) {
                    break;
                }
                save = temp;
                if (val < temp.val) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            if (save.val > val) {
                save.left = new TreeNode(val);
            } else {
                save.right = new TreeNode(val);
            }
            return root;
        }
    }
}
