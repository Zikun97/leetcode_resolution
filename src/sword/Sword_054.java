package sword;

import java.util.Deque;
import java.util.LinkedList;

public class Sword_054 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);

        Solution solution = new Solution();
        System.out.println();
        System.out.println(solution.kthLargest(root, 3));

    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 非递归的二叉树中序遍历
     * 效率： 41.06; 44.16
     */
    static class Solution {
        public int kthLargest(TreeNode root, int k) {
            int count = 0;
            TreeNode temp = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (temp != null || !stack.isEmpty()) {
                while (temp != null) {
                    stack.addLast(temp);
                    temp = temp.right;
                }
                if (!stack.isEmpty()) {
                    temp = stack.pollLast();
                    if (++count == k)
                        return temp.val;
                    System.out.println(temp.val);
                    temp = temp.left;
                }
            }
            return -1;
        }
    }

    // TODO: 2021/7/1 使用递归遍历试一试效率如何 
}