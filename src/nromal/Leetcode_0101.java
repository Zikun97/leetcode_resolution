package nromal;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0101 {

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
        public boolean isSymmetric(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            if (root != null && root.left != null && root.right != null){
                stack.offerLast(root.left);
                stack.offerLast(root.right);
            }

            while (!stack.isEmpty()) {
                int size = stack.size();
                Deque<TreeNode> nodes = new LinkedList<>();
                for (int i = 0; i < size; ++i) {
                    TreeNode node = stack.pollFirst();
                    nodes.addLast(node);
                    if (node != null) {
                        stack.addLast(node.left);
                        stack.addLast(node.right);
                    } else {
                        stack.addLast(null);
                        stack.addLast(null);
                    }
                }
                while (!nodes.isEmpty()) {
                    TreeNode a = nodes.pollFirst();
                    TreeNode b = nodes.pollLast();
                    if ((a != null && b == null) || (a == null && b != null)) {
                        return false;
                    }
                    if (a != null && b != null && a.val != b.val) {
                        return false;
                    }

                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(solution.isSymmetric(root));

    }
}
