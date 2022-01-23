package sword;


import java.util.Deque;

public class Sword_007 {

    public static void main(String[] args) {
        int[] preorder = {3,7};
        int[] inorder = {3, 7};
        Solution solution = new Solution();
        TreeNode head = solution.buildTree(preorder, inorder);
        System.out.println("yes");
    }

    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0)
                return null;
            TreeNode root = build(inorder, preorder, 0, preorder.length - 1, 0, inorder.length - 1);
            return root;
        }

        private TreeNode build(int[] inorder, int[] preorder, int p_start, int p_end, int i_start, int i_end) {
            if (p_start > p_end || i_start > i_end)
                return null;
            if (p_end == p_start)
                return new TreeNode(inorder[p_start]);
            TreeNode head = new TreeNode(preorder[i_start]);
            int new_p_end = p_start;
            while (inorder[new_p_end] != preorder[i_start])
                new_p_end ++;
                head.left = build(inorder, preorder, p_start, new_p_end - 1, i_start + 1, i_start + new_p_end - p_start);
                head.right = build(inorder, preorder, new_p_end + 1, p_end, i_start + new_p_end - p_start + 1, i_end);
            return head;
        }

    }
}
