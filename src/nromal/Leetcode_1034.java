package nromal;

public class Leetcode_1034 {

    class Solution {
        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            boolean[][] vis = new boolean[grid.length][grid[0].length];
            boolean[][] tag = new boolean[grid.length][grid[0].length];
            int init = grid[row][col];
            dfs(grid, vis, tag, row, col, init);
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (tag[i][j]) {
                        grid[i][j] = color;
                    }
                }
            }
            return grid;
        }

        private void dfs(int[][] grid, boolean[][] vis, boolean[][] tag, int row, int col, int init) {
            if (vis[row][col]) {
                return;
            }
            vis[row][col] = true;
            if (grid[row][col] == init) {
                if (isEdge(grid, row, col)) {
                    tag[row][col] = true;
                }
                if (row > 0) {
                    dfs(grid, vis, tag, row - 1, col, init);
                }
                if (col > 0) {
                    dfs(grid, vis, tag, row, col - 1, init);
                }
                if (row < grid.length - 1) {
                    dfs(grid, vis, tag, row + 1, col, init);
                }
                if (col < grid[0].length - 1) {
                    dfs(grid, vis, tag, row, col + 1, init);
                }
            }
        }

        private boolean isEdge(int[][] grid, int row, int col) {
            int color = grid[row][col];
            if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
                return true;
            }
            return grid[row - 1][col] != color || grid[row + 1][col] != color
                    || grid[row][col - 1] != color || grid[row][col + 1] != color;
        }
    }
}
