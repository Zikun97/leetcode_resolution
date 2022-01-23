package nromal;

import sun.nio.cs.ext.MacHebrew;

public class Leetcode_0122 {

    /**
     * 题目：买卖股票的最佳时机
     */


    /**
     * 贪心解法
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int ans = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] - prices[i - 1] > 0) {
                    ans += prices[i] - prices[i - 1];
                }
            }
            return ans;
        }
    }

    /**
     * 动态规划解法
     */
    class Solution0 {
        public int maxProfit(int[] prices) {
            // dp[i][0]存储持有股票的最大值
            // dp[i][1]存储没有股票的最大值
            int[][] dp = new int[prices.length][2];

            //初始化
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; ++i) {
                // 当前节点持有股票的最大利润值 = max(上一个节点持有股票的最大值【即该节点啥都没做】, 上一个节点没有股票的最大利润 - 该节点的股票值【该节点购入股票】)
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                // 当前节点没有股票的最大利润值 = max(上一个节点没有股票的最大值【即该节点啥都没做】, 上一个节点持有股票的最大利润 + 该节点的股票值【该节点卖出股票】)
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }
}
