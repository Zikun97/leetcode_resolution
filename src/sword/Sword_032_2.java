package sword;

import javafx.util.Pair;

import java.util.*;

public class Sword_032_2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null)
                return new LinkedList<>();
            Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            LinkedList<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> temp_list = null;
            queue.add(new Pair<>(root, 0));
            int temp_layer = -1;

            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> pair = queue.pollFirst();
                int layer = pair.getValue();
                TreeNode temp  = pair.getKey();
                if (temp_layer != layer) {
                    if (temp_list != null) {
                        res.add(temp_list);
                    }
                    temp_layer = layer;
                    temp_list = new LinkedList<>();
                }
                temp_list.addLast(temp.val);


                if (temp.left != null) {
                    queue.addLast(new Pair<>(temp.left, layer + 1));
                }
                if (temp.right != null) {
                    queue.addLast(new Pair<>(temp.right,layer + 1));
                }
            }
            res.add(temp_list);
            return  res;
        }
    }

    /*** 2021/5/31 reference 更优秀的解法，使用简单的结构，达到更优秀的结果 */
    static class Solution_1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<>();
            LinkedList<List<Integer>> result = new LinkedList<>();
            if (root != null) {
                deque.addFirst(root);
            }

            while (!deque.isEmpty()) {
                LinkedList<Integer> single_result = new LinkedList<>();
                for (int i = deque.size(); i > 0; i--) {
                    TreeNode node = deque.pollFirst();
                    single_result.add(node.val);
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
                result.add(single_result);
            }
            return result;
        }
    }


}
