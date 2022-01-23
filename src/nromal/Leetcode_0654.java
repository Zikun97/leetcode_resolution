package nromal;

public class Leetcode_0654 {

    static class Solution {
        private int[] nums;
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            this.nums = nums;
            return build(0, nums.length - 1);
        }

        private TreeNode build(int start, int end) {
            if (end < start) {
                return null;
            }
            if (start == end) {
                return new TreeNode(nums[end]);
            }
            int idx = start;
            int maxIdx = start;
            while (idx <= end) {
                if (nums[idx] > nums[maxIdx]) {
                    maxIdx = idx;
                }
                ++idx;
            }
            TreeNode node = new TreeNode(nums[maxIdx]);
            node.left = build(start, maxIdx - 1);
            node.right = build(maxIdx + 1, end);
            return node;
        }
    }
}
