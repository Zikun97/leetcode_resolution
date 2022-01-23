package sword;

public class Sword_019 {

    static class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length()][p.length()];
            for (int i = 0; i < s.length(); ++i) {
                for (int j = 0; j < p.length(); ++i) {
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }

                    } else if (p.charAt(j) == s.charAt(i)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[s.length() - 1][p.length() - 1];
        }


    }
}
