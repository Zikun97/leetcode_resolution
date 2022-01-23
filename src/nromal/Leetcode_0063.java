package nromal;

public class Leetcode_0063 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            for (int i = 0; i < obstacleGrid[0].length; ++i) {
                if (obstacleGrid[0][i] == 0) {
                    dp[0][i] = 1;
                }
            }

            for (int i = 1; i < obstacleGrid.length; ++i) {
                if (obstacleGrid[i][0] == 0) {
                    dp[i][0] = 1;
                }
            }

            for (int i = 0; i < obstacleGrid.length; ++i) {
                for (int j = 0; j < obstacleGrid[0].length; ++j) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }

            return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

        }
    }
}
