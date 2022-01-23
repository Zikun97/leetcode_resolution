package sword;

public class Sward_004 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Solution_1 solution_1 = new Solution_1();

        System.out.println(solution_1.findNumberIn2DArray(nums, 90));
    }

    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            boolean[][] flags = new boolean[matrix.length][matrix[0].length];

            return find(matrix, flags, 0, 0, matrix.length, matrix[0].length, target);
        }

        public boolean find(int[][] matrix, boolean[][] flags, int i, int j, int n, int m, int target) {
            System.out.println("yy");
            if (i < 0 || i >= n || j <0 || j >=m)
                return false;
            if (flags[i][j] == true)
                return false;
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target) {
                flags[i][j] = true;
                return find(matrix, flags, i - 1, j, n, m, target) || find(matrix, flags, i, j - 1, n, m, target);
            } else{
                flags[i][j] = true;
                return find(matrix, flags, i + 1, j, n, m, target) || find(matrix, flags, i, j + 1, n, m, target);
            }

        }
    }


    static class Solution_1 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int i = 0, j = columns - 1;
            while (i < rows && j >= 0) {
                int num = matrix[i][j];
                if (num == target)
                    return true;
                else if (num > target)
                    j --;
                else
                    i ++;
            }
            return false;

        }
    }

}

