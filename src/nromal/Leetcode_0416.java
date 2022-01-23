package nromal;

import java.util.Arrays;

public class Leetcode_0416 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canPartition(new int[]{2, 11, 4, 5});
    }

    /**
     * 题目:分割等和子集
     */


    /**
     * 比较隐蔽的0-1背包问题
     */
    static class Solution {
        public boolean canPartition(int[] nums) {
            int weights = Arrays.stream(nums).sum();
            if ((weights & 1) == 1) {
                return false;
            }
            weights /= 2;
            // 设置dp数组
            // dp[i][j]的含义：在0 - i个物品中，总重量小于等于j，价值的最大值
            int[][] dp = new int[nums.length][weights + 1];


            // 初始化时，重量为0，肯定塞不进去东西，所以值为0(其实默认值都是0，不初始化也行)
//            for (int i = 1; i < nums.length; ++i) {
//                dp[i][0] = 0;
//            }

            // 初始化
            for (int j = nums[0]; j < weights; ++j) {
                dp[0][j] = nums[0];
            }


            // 确定转移方程
            for (int i = 1; i < nums.length; ++i) {
                for (int j = 1; j <= weights; ++j) {
                    if (j >= nums[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[nums.length - 1][weights] == weights;
        }
    }
}
