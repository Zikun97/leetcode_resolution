package sword;

public class Sword_042 {

    /**
     * 很经典的dp问题，奈何脑子不行，只能参考别人的代码
     * 效率：98.69; 70.39
     */
    static class Solution {
        public int maxSubArray(int[] nums) {
            int res = Integer.MIN_VALUE;
            int x = -1;
            for (int num : nums) {
                x = x > 0 ? x + num : num;
                res = Math.max(x, res);
            }
            return res;
        }
    }
}
