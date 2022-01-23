package nromal;

import java.util.*;

public class Leetcode_0257 {
    
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

    /***
     * 问题：获取二叉树所有的路径
     */

    /**
     * 迭代法
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Deque<TreeNode> deque = new LinkedList<>();
            Deque<String> paths = new LinkedList<>();
            List<String> ans = new ArrayList<>();
            if (root != null) {
                deque.addLast(root);
                paths.addLast(String.valueOf(root.val));
            }
            while (!deque.isEmpty()) {
                TreeNode node = deque.pollLast();
                String path = paths.pollLast();

                // 如果是当前节点是叶子节点
                if (node.left == null && node.right == null) {
                    ans.add(path);
                }

                if (node.right != null) {
                    deque.addLast(node.right);
                    paths.addLast(path + "->" + node.right.val);
                }
                if (node.left != null) {
                    deque.addLast(node.left);
                    paths.addLast(path + "->" + node.left.val);
                }
            }
            return ans;
        }
    }

    /**
     * 递归法
     */
    static class Solution_0 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            findPath(root, String.valueOf(root.val), ans);
            return ans;
        }

        public void findPath(TreeNode root, String str, List<String> ans) {
            if (root.left == null && root.right == null) {
                ans.add(str);
            }
            if (root.left != null) {
                findPath(root.left, str + "->" + root.left.val, ans);
            }
            if (root.right != null) {
                findPath(root.right, str + "->" + root.right.val, ans);
            }
        }
    }
}
