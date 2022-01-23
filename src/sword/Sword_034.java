package sword;

import java.util.LinkedList;
import java.util.List;

public class Sword_034 {

    public static void main(String[] args) {
        List<Integer> src_list = new LinkedList<>();
        for (int i = 0; i < 10; ++i) {
            src_list.add(i);
        }

        List<Integer> dst_list = new LinkedList<>(src_list);

        dst_list.add(3);

        for (Integer i : src_list) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (Integer i : dst_list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

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


    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int target) {

            LinkedList<List<Integer>> result = new LinkedList<>();
            LinkedList<Integer> path_num = new LinkedList<>();
            isHavePathSum(root, target, 0, path_num, result);
            return result;
        }

        private void isHavePathSum(TreeNode node, int target, int sum, LinkedList<Integer> path_num, List<List<Integer>> result) {
            // 先判断是否跳出条件
            if (node == null)
                return;
            if (node.left == null && node.right == null)
            {
                if (node.val + sum == target) {
                    LinkedList<Integer> one_result = new LinkedList<>(path_num);
                    one_result.add(node.val);
                    result.add(one_result);
                }
                return;
            }

            path_num.addLast(node.val);
            isHavePathSum(node.left, target, sum + node.val, path_num, result);
            isHavePathSum(node.right, target, sum + node.val, path_num, result);
            path_num.removeLast();

        }
    }
}

