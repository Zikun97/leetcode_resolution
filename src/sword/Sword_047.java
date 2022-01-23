package sword;

public class Sword_047 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println(solution.maxValue(grid));
    }

    /**
     * 比较经典的动态规划，没啥好说的
     * 效率：90/80+; 10+
     * 可能很多人使用原数组进行更新，导致内存较小
     */
    static class Solution {
        public int maxValue(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            int[] result = new int[grid[0].length];
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (i == 0) {
                        result[j] = j == 0 ? grid[i][j] : grid[i][j] + result[j - 1];
                    } else {
                        result[j] = j == 0 ? grid[i][j] + result[j] : Math.max(result[j], result[j - 1]) + grid[i][j];
                    }
                }
            }
            return result[result.length - 1];
        }
    }

}
