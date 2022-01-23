package sword;

public class Sword_033 {

    public static void main(String[] args) {
        int[] postorder = {1,3,2,6,5};
        Solution solution = new Solution();
        boolean res = solution.verifyPostorder(postorder);
        System.out.println(res);
    }

    static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return judge(postorder, 0, postorder.length - 1);
        }


        private boolean judge(int[] postorder, int start, int end) {
            if (start >= end)
                return true;
            int end_num = postorder[end];
            int mediam = start;
            while (postorder[mediam] < end_num) {
                mediam++;
            }

            for (int k = mediam; k < end; k++) {
                if (postorder[k] <= end_num) {
                    return false;
                }
            }
            return judge(postorder, start, mediam - 1) && judge(postorder, mediam, end -1);
        }
    }
}
