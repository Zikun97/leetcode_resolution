package nromal;

public class Leetcode_0807 {

    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int[] rows = new int[grid.length];
            int[] cols = new int[grid[0].length];

            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (rows[i] < grid[i][j]) {
                        rows[i] = grid[i][j];
                    }
                    if (cols[j] < grid[i][j]) {
                        cols[j] = grid[i][j];
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    int great = Math.min(rows[i], cols[j]);
                    if (grid[i][j] < great) {
                        ans += great - grid[i][j];
                    }
                }
            }
            
            return ans;
        }
    }
}
