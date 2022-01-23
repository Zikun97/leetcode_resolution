package nromal;

import java.util.Arrays;

public class Leetcode_1049 {


    /**
     * 题目：最后一块石头的重量
     */

    /**
     * 思路：将石头分为两堆，并保证两堆石头的差值最小。
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {14,1,7,17,8,10};
        int res = solution.lastStoneWeightII(stones);
        System.out.println(res);
    }

    static class Solution {
        public int lastStoneWeightII(int[] stones) {

            int sum = Arrays.stream(stones).sum();
            int weight = sum / 2;

            // 转化为背包问题
            // 石头作为物品（后面统称为物品），物品的重量和价值相同
            // 背包容量为全部石头总重量的一半，尽可能得装更多价值的物品
            int[][] dp= new int[stones.length][weight + 1];

            // 初始化第0行：当weight超过stone[0]的重量，则可以加入
            for (int i = stones[0]; i <= weight; ++i) {
                dp[0][i] = stones[0];
            }

            // 开始动态规划
            for (int i = 1; i < dp.length; ++i) {
                for (int j = 0; j <= weight; ++j) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= stones[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i]] + stones[i]);
                    }
                }
            }
            System.out.println(sum);
            System.out.println(dp[stones.length - 1][weight]);
            return sum - 2 * dp[stones.length - 1][weight];
        }
    }
}
