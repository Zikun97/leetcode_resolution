package hot_100;

public class Hot_010 {
    static public void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaa";
        String p = "a*";
        boolean res = solution.isMatch(s, p);
        System.out.println(res);



    }

    static class Solution{
        public boolean isMatch(String s, String p) {
            int len_s = s.length(), len_p = p.length();
            boolean dp[][] = new boolean[len_s + 1][len_p + 1];
            dp[0][0] = true;
            for (int i = 0; i <= len_s; ++i) {
                for (int j = 1; j <= len_p; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        if (i > 0 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                            dp[i][j] = dp[i][j-2] || dp[i-1][j];
                        } else {
                            dp[i][j] = dp[i][j-2];
                        }
                    } else if (i >0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[len_s][len_p];
        }


    }
}
