package hot_100;

public class Hot_070 {

    class Solution {
        int[] dp = new int[1000005];
        {
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < 1000005; ++i) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        public int climbStairs(int n) {
            return dp[n];
        }

    }
}
