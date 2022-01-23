package sword;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sword_032_3 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<List<Integer>> result = new LinkedList<>();
            if (root != null) {
                queue.addLast(root);
            }
            boolean reverse = false;

            while (!queue.isEmpty()) {
                LinkedList<Integer> single_result = new LinkedList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode treeNode = queue.pollFirst();
                    single_result.addLast(treeNode.val);
                    if (treeNode.left != null) {
                        queue.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.addLast(treeNode.right);
                    }

                }
                if (reverse) {
                    LinkedList<Integer> reverse_single_result = new LinkedList<>();
                    for (int i = single_result.size() - 1; i >= 0; i--) {
                        reverse_single_result.addLast(single_result.get(i));
                    }
                    result.addLast(reverse_single_result);
                    reverse = false;
                } else {
                    result.addLast(single_result);
                    reverse = true;
                }

            }
            return result;
        }
    }

}
