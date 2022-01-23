package sword;

import java.util.LinkedList;
import java.util.List;

public class Sword_029 {

    public static void main(String[] args) {
        int cows = 1;
        int columns = 1;
        int[][] matrix = new int[cows][columns];
        int index = 0;
        for (int i = 0; i < cows; ++i) {
            for (int j = 0; j < columns; ++j) {
                matrix[i][j] = index ++;
            }
        }

        Solution solution = new Solution();

        int[] res = solution.spiralOrder(matrix);

        for (int i = 0; i < res.length; ++i) {
            System.out.println(res[i]);
        }

    }

     /*** 2021/5/13 官方解法  使用visited矩阵和direction数组来创建 */


    static class Solution {
        public int[] spiralOrder(int[][] matrix) {
            int rows = matrix.length;
            int columns = matrix[0].length;
            int[] result = new int[rows * columns];
            print_num(matrix, result, 0, 0, 0, rows - 1, columns - 1);
            return result;
        }

        private void print_num(int[][] matrix, int[] dst, int idx, int x_0, int y_0, int x_1, int y_1) {
            if (x_0 > x_1 || y_0 > y_1)
                return;

            if (x_0 == x_1 && y_0 == y_1) {
                dst[idx ++] = matrix[x_0][y_0];
                return;
            }

            boolean flag1 = false, flag2 = false;
            for (int i = y_0; i < y_1; ++i) {
                dst[idx ++] = matrix[x_0][i];
                flag1 = true;
            }

            for (int i = x_0; i < x_1; ++i) {
                dst[idx ++] = matrix[i][y_1];
                flag2 =true;
            }
            if (flag2) {
                for (int i = y_1; i > y_0; --i) {
                    dst[idx ++] = matrix[x_1][i];
                }
            }

            if (flag1) {
                for (int i = x_1; i > x_0; --i) {
                    dst[idx ++] = matrix[i][y_0];
                }
            }

            if (flag2 && flag1) {
                ++ x_0;
                -- x_1;
                ++ y_0;
                -- y_1;
            } else if (flag1) {
                y_0 = y_1;
            } else if (flag2) {
                x_0 = x_1;
            }

            print_num(matrix, dst, idx, x_0, y_0, x_1, y_1);
        }
    }


}
