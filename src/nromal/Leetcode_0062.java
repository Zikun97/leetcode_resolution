package nromal;

public class Leetcode_0062 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int uniquePaths(int m, int n) {
            // 初始化
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; ++i) {
                dp[0][i] = 1;
            }
            for (int i = 0; i < m; ++i) {
                dp[i][0] = 1;
            }


            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m][n];
        }
    }


    /**
     * 可以考虑仅使用一维数组
     */
}
