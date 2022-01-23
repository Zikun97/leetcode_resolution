package nromal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_1609 {


    /**
     * 题目：奇偶树
     */


    /**
     * 解法： bfs(自己写的，比较low
     */
    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            Deque<TreeNode> list = new LinkedList<>();
            boolean isOdd = false;
            int val = 0;
            list.add(root);
            list.add(null);
            while (!list.isEmpty()) {
                TreeNode node = list.pollFirst();
                if (node == null) {
                    isOdd = !isOdd;
                    val = 0;
                    if (list.isEmpty()) {
                        break;
                    }
                    list.add(null);
                } else {
                    if (isOdd) { // 奇数层，都是偶数， 且严格单调减
                        if ((node.val & 1) == 1) {
                            return false;
                        }
                        if (val == 0) {
                            val = node.val;
                        } else {
                            if (node.val >= val) {
                                return false;
                            }
                            val = node.val;
                        }
                    } else {    // 偶数层，都是奇数，且严格单调增
                        if ((node.val & 1) == 0) {
                            return false;
                        }
                        if (val == 0) {
                            val = node.val;
                        } else {
                            if (node.val <= val) {
                                return false;
                            }
                            val = node.val;
                        }
                    }
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                }
            }
            return true;
        }
    }


    /**
     * 官方题解：优雅的bfs
     */
    class Solution_0 {
        public boolean isEvenOddTree(TreeNode root) {
            int level = 0;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerLast(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                int pred = (level & 1) == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                for (int i = 0; i < size; ++i) {
                    TreeNode node = deque.pollFirst();
                    if ((level & 1) == 0) {
                        if ((node.val & 1) == 0) {
                            return false;
                        }
                        if (node.val <= pred) {
                            return false;
                        }
                    } else {
                        if ((node.val & 1) == 1) {
                            return false;
                        }
                        if (node.val >= pred) {
                            return false;
                        }
                    }
                    pred = node.val;
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                }

                ++level;
            }
            return true;
        }
    }
}
