package sword;

public class Sword_055_2 {




    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
    }


    /**
     * 朴素做法：在每个节点判断左右子树的深度，从下至上判断，一旦发现平衡因子大于1，立即返回错误
     * 效率：100; 35.07
     */
    static class Solution {

        boolean isBalanced = true;
        public boolean isBalanced(TreeNode root) {
            treeDepth(root);
            return isBalanced;
        }

        public int treeDepth(TreeNode root) {
            if (!isBalanced)
                return -1;
            if (root == null)
                return 0;
            int a = treeDepth(root.left);
            int b = treeDepth(root.right);
            if (Math.abs(a - b) > 1) {
                isBalanced = false;
                return -1;
            }
            return Math.max(a, b) + 1;
        }
    }

}
