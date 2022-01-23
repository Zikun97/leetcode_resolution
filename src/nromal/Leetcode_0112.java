package nromal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_0112 {
    /**
     * 题目：判断树中有没有路径之和为target的情况
     */

    /**
     * 递归法
     */
    static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            return dfs(root, targetSum, 0);
        }

        private boolean dfs(TreeNode node, int target, int sum) {
            if (node.left == null && node.right == null) {
                if (node.val + sum == target) {
                    return true;
                }
            }
            boolean left = false;
            boolean right = false;
            if (node.left != null) {
                left = dfs(node.left, target, sum + node.val);
                if (left) {
                    return true;
                }
            }

            if (node.right != null) {
                right = dfs(node.right, target, sum + node.val);
                return right;
            }
            return false;
        }
    }


    /**
     * 迭代法
     */
    static class Solution0 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            Deque<Integer> sums = new LinkedList<>();
            deque.add(root);
            sums.add(root.val);
            while (!deque.isEmpty()) {
                TreeNode node = deque.pollLast();
                int temp = sums.pollLast();
                if (node.left == null && node.right == null) {
                    if (temp == targetSum) {
                        return true;
                    }
                }
                if (node.right != null) {
                    sums.addLast(node.right.val + temp);
                    deque.addLast(node.right);
                }
                if (node.left != null) {
                    sums.addLast(node.left.val + temp);
                    deque.addLast(node.left);
                }
            }
            return false;
        }
    }
}
