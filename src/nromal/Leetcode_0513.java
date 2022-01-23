package nromal;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0513 {


    /**
     * 赵树左下角的值
     */

    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ans = root.val;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                boolean first = true;
                for (int i = 0; i < size; ++i) {
                    TreeNode node = deque.pollFirst();
                    if (node.left != null) {
                        deque.addLast(node.left);
                        if (first) {
                            ans = node.left.val;
                            first = false;
                        }
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                        if (first) {
                            ans = node.right.val;
                            first = false;
                        }
                    }
                }

            }

            return ans;
        }

    }
}
