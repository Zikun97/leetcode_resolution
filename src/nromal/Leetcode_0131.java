package nromal;

import sun.applet.Main;

import java.util.*;

public class Leetcode_0131 {

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.substring(0,2));
    }

    class Solution {

        private List<List<String>> ans = new ArrayList<>();
        private Deque<String> temp = new LinkedList<>();
        private boolean[][] dp;

        public List<List<String>> partition(String s) {

            // 会重复搜索浪费很多时间，可以使用动态规划方法。
            boolean[][] dp = new boolean[s.length()][s.length()];
            // 初始化为true
            for (int i = 0; i < s.length(); ++i) {
                Arrays.fill(dp[i], true);
            }
            // 使用dp
            for (int i = s.length() - 1; i >=0; --i) {
                for (int j = i + 1; j < s.length(); ++j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
            }
            this.dp = dp;

            backTracking(s, 0);
            return ans;
        }


        private void backTracking(String s, int start) {
            if (start == s.length()) {
                ans.add(new LinkedList<>(temp));
                return;
            }

            for (int i = start; i < s.length(); ++i) {
                if (dp[start][i]) {
                    temp.addLast(s.substring(start, i + 1));
                    backTracking(s, i + 1);
                    temp.removeLast();
                }
            }
        }


        // 判断是否为回文串
//        private boolean isRound(String s, int start, int end) {
//            if (start == end) {
//                return true;
//            }
//            int mid = (end - start) / 2;
//            for (int i = 0; i <= mid; ++i) {
//                if (s.charAt(start + i) != s.charAt(end - i)) {
//                    return false;
//                }
//            }
//            return true;
//        }
    }
}
