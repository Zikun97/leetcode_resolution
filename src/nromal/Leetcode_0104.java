package nromal;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0104 {

    
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
    class Solution {
        public int maxDepth(TreeNode root) {
            int depth = 0;
            Deque<TreeNode> deque = new LinkedList<>();
            if (root != null) {
                ++ depth;
                deque.offerLast(root);
            }
            while (!deque.isEmpty()) {
                int size = deque.size();
                ++depth;
                for (int i = 0; i < size; ++i) {
                    TreeNode node = deque.pollFirst();
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
            }
            return depth;
        }
    }

}
