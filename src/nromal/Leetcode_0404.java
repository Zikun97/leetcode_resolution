package nromal;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
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

public class Leetcode_0404 {
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            int ans = 0;
            Deque<TreeNode> deque = new LinkedList<>();
            if (root != null) {
                deque.addLast(root);
                deque.addLast(null);
            }
            while (!deque.isEmpty()) {
                TreeNode node = deque.pollLast();
                if (node != null) {
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    if (node.left != null) {
                        deque.addLast(node.left);
                        deque.addLast(null);
                    }
                } else {
                    node = deque.pollLast();
                    if (node.left == null && node.right == null) {
                        ans += node.val;
                        continue;
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    if (node.left != null) {
                        deque.addLast(node.left);
                        deque.addLast(null);
                    }
                }
                
            }
            return ans;
        }
    }
}
