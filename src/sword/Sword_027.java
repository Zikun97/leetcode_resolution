package sword;

public class Sword_027 {

    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            exchange(root);
            return root;
        }

        private void exchange(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            exchange(root.left);
            exchange(root.right);
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
