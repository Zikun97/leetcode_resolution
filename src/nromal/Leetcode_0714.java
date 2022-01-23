package nromal;



public class Leetcode_0714 {


    private Leetcode_0714() {

    }
    public static void main(String[] args) {
        Solution0 solution = new Solution0();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 1;
        System.out.println(solution.maxProfit(prices, fee));
        System.out.println(2 & 4);

    }
    /**
     * 题目：买卖股票的最佳时机含手续费
     * start:
     * end:
     */


    /**
     * 解法：动态规划
     * 贪心没有思路，呜呜呜
     */
    static class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices.length == 0) {
                return 0;
            }
            // 持有数组
            int[] have = new int[prices.length];
            int[] noHave = new int[prices.length];

            have[0] = -prices[0];
            for (int i = 1; i < prices.length; ++i) {
                have[i] = Math.max(have[i - 1], noHave[i - 1] - prices[i]);
                noHave[i] = Math.max(noHave[i - 1], have[i - 1] + prices[i] - fee);
            }
            return have[prices.length - 1];
        }
    }

    /**
     * 题解：贪心做法
     * 只能学学大佬的做法了
     */

    static class Solution0 {
        public int maxProfit(int[] prices, int fee) {
            if (prices.length == 0) {
                return 0;
            }
            // 最后的结果
            int ans = 0;
            // 目前最小的值
            int minPrice = prices[0];
            for (int ele : prices) {
                // 更新最小值
                if (minPrice > ele) {
                    minPrice = ele;
                }
                // 做的是无用交易，会亏钱, 啥都不做
//                if (ele - minPrice - fee <= 0) {
//                    continue;
//                }

                // 会挣钱啊，这不得卖卖卖啊
                if (ele - minPrice - fee > 0) {
                    ans += ele - minPrice - fee;
                    minPrice = ele - fee; // 认为该点并不是最后的卖出点，认为是中间点
                    System.out.println(ans);
                }
            }
            return ans;
        }
    }
}
