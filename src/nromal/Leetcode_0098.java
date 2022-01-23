package nromal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

public class Leetcode_0098 {

    /***
     * 题目：判断是否是搜索二叉树
     */


    /**
     * 朴素做法：中序遍历求解
     */
    static class Solution {

        private List<Integer> list = new ArrayList<>();
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            dfs(root);
            Iterator<Integer> integerIterator = list.iterator();
            int temp = integerIterator.next();
            while (integerIterator.hasNext()) {
                int integer = integerIterator.next();
                if (integer <= temp) {
                    return false;
                }
                temp = integer;
            }
            return true;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            this.list.add(root.val);
            dfs(root.right);

        }
    }


    /**
     * 进阶做法：递归求解
     */

    static class Solution0 {

        public boolean isValidBST(TreeNode root) {

            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean dfs(TreeNode root, long low, long high) {
            if (root == null) {
                return true;
            }
            if (root.val <= low || root.val >= high) {
                return false;
            }
            return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
        }

    }


}
