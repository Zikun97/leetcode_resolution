package sword;

public class Sword_055_1 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        System.out.println(solution.maxDepth(root));
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    /**
     * 就是遍历二叉树即可，但是涉及到回溯，别忘记回溯条件了
     * 效率：100; 78.88
     */
    static class Solution {
        
        int max = 0;
        int layer = 0;
        
        public int maxDepth(TreeNode root) {
            if (root != null) {
                if (++layer > max)
                    max = layer;
            } else {
                return 0;
            }
            if (maxDepth(root.left) != 0)
                --layer;
            if (maxDepth(root.right)!=0)
                --layer;
            return max;
        }
    }
}
