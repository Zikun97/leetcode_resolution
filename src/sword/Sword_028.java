package sword;

public class Sword_028 {




 
    static class Solution {
        public boolean isSymmetric(TreeNode root) {

            if (root == null)
                return true;
            TreeNode metric_root = new TreeNode(0);
            return judge(root, root);

        }


        private boolean judge(TreeNode x, TreeNode y) {
            if (x.val != y.val)
                return false;
            if ((x.right == null && y.left != null) || (x.right != null && y.left == null) ||
                    (x.left == null && y.right != null) || (x.left != null && y.right == null)) {
                return false;
            }
            boolean flag = true;
            if (x.right != null && y.left != null)
                flag = flag && judge(x.right, y.left);
            if (x.left != null && y.right != null)
                flag = flag && judge(x.left, y.right);
            return flag;
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
