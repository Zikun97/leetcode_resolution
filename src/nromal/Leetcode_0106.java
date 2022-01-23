package nromal;

public class Leetcode_0106 {

    /**
     * 题目：从中序和后序遍历求出树
     */
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode build(int[] inorder, int start0, int end0,  int[] postorder, int start1, int end1) {
            if (start0 > end0 || start1 > end1) {
                return null;
            }
            if (start0 == end0) {
                return new TreeNode(inorder[start0]);
            }
            TreeNode node = new TreeNode(postorder[end1]);
            int idx = start0;
            for (; idx <= end0; ++idx) {
                if (inorder[idx] == postorder[end1]) {
                    break;
                }
            }

            node.left = build(inorder, start0, idx - 1, postorder, start1, start1 + idx - start0 - 1);
            node.right = build(inorder, idx + 1, end0, postorder, start1 + idx - start0, end1);
            return node;
        }

        /**
         * 优化思路：inorder使用哈希表，降低查找速率
         */


    }
}
