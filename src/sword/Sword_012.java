package sword;

public class Sword_012 {


    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
        String word = "a";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            boolean res = false;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (board[i][j] == word.charAt(0)) {
                        if (word.length() == 1)
                            return true;
                        res = visit(board, i, j, word, 0, visited);
                    }
                    if (res) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean visit(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
            if (index == word.length())
                return true;
            if (visited[i][j]) {
                return false;
            }
            if (board[i][j] == word.charAt(index)) {
                visited[i][j] = true;
                boolean res = false;
                if (i + 1 < board.length) {
                    res = res || visit(board, i + 1, j, word, index + 1, visited);
                }
                if (i - 1 >= 0) {
                    res = res || visit(board, i - 1, j, word, index + 1, visited);
                }
                if (j + 1 < board[0].length) {
                    res = res || visit(board, i, j + 1, word, index + 1, visited);
                }
                if (j - 1 >= 0) {
                    res = res || visit(board, i, j - 1, word, index + 1, visited);
                }
                visited[i][j] = false;
                return res;
            }

            return false;
        }
    }
}
