package nromal;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0111 {

    public class TreeNode {
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

    /***
     * 会超时
     */
    class Solution {
        public int minDepth(TreeNode root) {
            return min(root);
        }
        private int min(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = min(root.left);
            int right = min(root.right);
            if (right != 0 && right != 0) {
                return Math.min(min(root.left), min(root.right)) + 1;
            }
            else if (left == 0) {
                return right + 1;
            }
            else {
                return left + 1;
            }
        }
    }


    class Solution_1 {
        public int minDepth(TreeNode root) {
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
                    if (node.right == null && node.left == null) {
                        return depth + 1;
                    }
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
