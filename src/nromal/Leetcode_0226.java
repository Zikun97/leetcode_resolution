package nromal;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0226 {


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
    
    class Solution {
        public TreeNode invertTree(TreeNode root) {

            invert(root);
            return root;
        }

        private void invert(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            invert(root.left);
            invert(root.right);
        }
    }

    class Solution_0 {
        public TreeNode invertTree(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            if (root != null) {
                stack.addLast(root);
            }
            while (!stack.isEmpty()) {
                int size = stack.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode node = stack.pollLast();
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                    if (node.left != null) {
                        stack.offerLast(node.left);
                    }
                    if (node.right != null) {
                        stack.offerLast(node.right);
                    }
                }
            }

            return root;
        }
    }
}
