package sword;

public class Sword_026 {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null || A == null)
                return false;
            boolean flag = true;
            if (isSame(A, B)) {
                return true;
            } else {
                flag = isSubStructure(A.left, B);
                flag = isSubStructure(A.right, B) || flag;
                return flag;
            }
        }

        private boolean isSame(TreeNode x, TreeNode y) {
            // System.out.println(x.val);
            // System.out.println(y.val);
            boolean flag = true;
            if (x.val == y.val) {
                if (y.left != null) {
                    if (x.left != null) {
                        // System.out.println("one");
                        flag = isSame(x.left, y.left);
                    } else
                        return false;
                }

                if (y.right != null) {
                    if (x.right != null) {
                        // System.out.println("two");
                        flag = flag && isSame(x.right, y.right);
                    } else
                        return false;
                }
                return flag;
            }
            return false;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
