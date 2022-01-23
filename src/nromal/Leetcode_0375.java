package nromal;

public class Leetcode_0375 {

    /**
     * 题目： 猜数字大小
     */
    class Solution {
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n + 1][n + 1];
            for (int i = n; i > 0; --i) {
                for (int j = i + 1; j <= n; ++j) {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; ++k) { // 这里为什么不是 k<=j呢？
                        int temp = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                        min = Math.min(min, temp);
                    }
                    dp[i][j] = min;
                }
            }
            return dp[1][n];
        }
    }
}
