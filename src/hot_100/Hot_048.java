package hot_100;

import java.util.Arrays;

public class Hot_048 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int len = matrix.length;
            int[][] cur = new int[len][len];
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < len; ++j) {
                    cur[j][len - i - 1] = matrix[i][j];
                }
            }

            for (int i = 0; i < len; ++i) {
                System.arraycopy(cur[i], 0, matrix[i], 0, len);
            }
        }
    }

    static class Solution_0 {
        public void rotate(int[][] matrix) {
            int len = matrix.length;
            int limit = len / 2;
            for (int i = 0; i < limit; ++i) {
                for (int j = 0; j < len - limit; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[len - 1 - j][i];
                    matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                    matrix[len - 1 - i][len - 1 - j] = matrix[j, len - 1 - i];
                    matrix[j][len - 1 - j] = temp;
                }
            }
        }
    }
}
