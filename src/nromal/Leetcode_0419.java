package nromal;

public class Leetcode_0419 {


    /**
     * 朴素做法，遍历
     */
    class Solution {
        public int countBattleships(char[][] board) {
            int ans = 0;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (board[i][j] == 'X') {
                        if (i == 0) {
                            if (j == 0 || board[i][j - 1] == '.') {
                                ++ ans;
                            }
                        } else if (j == 0) {
                            if (board[i - 1][j] == '.') {
                                ++ ans;
                            }
                        } else if (board[i][j - 1] == '.' && board[i - 1][j] == '.') {
                            ++ ans;
                        }
                    }
                }
            }

            return ans;
        }
    }


    // todo 并查集
}
