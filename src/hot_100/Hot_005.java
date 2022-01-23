package hot_100;

public class Hot_005 {

    public static void main(String[] args){
        Solution_2 solution = new Solution_2();
        String s = "aggggaljljljljljdddddd";
        System.out.println(solution.longestPalindrome(s));
    }

    // TODO: 2021/3/19 dp法：参考官方思路，写得比较糙 
    static class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            boolean[][] pr = new boolean[len][len];
            int max = 1;
            int start = 0, end = 0;

            for (int l = 0; l < len; ++l) {
                for (int i = 0; i < len; ++i) {
                    int j = i + l;
                    if (j == i) {
                        pr[i][j] = true;
                    }
                    if (j < len) {
                        if (i + 1 >= len || j - 1 < 0) {
                            continue;
                        }
                        if (l == 1 && s.charAt(j) == s.charAt(i)) {
                            pr[i][j] = true;
                            if (l >= max) {
                                max = l + 1;
                                start = i;
                                end = j;
                            }

                        }
                        if (pr[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                            pr[i][j] = true;
                            if (l >= max) {
                                max = l + 1;
                                start = i;
                                end = j;
                            }
                        }
                    }
                }
            }
            return s.substring(start, end+1);
        }
    }

    // TODO: 2021/3/19 dp法：再次参考官方思路，相对优美 
    static class Solution_1{
        public String longestPalindrome(String s){
            int len = s.length();
            boolean dp[][] = new boolean[len][len];
            int max = 1;
            int start = 0, end = 0;
            for (int l = 0; l < len; ++l) {
                for (int i = 0; i +l < len; ++i){
                    int j = i + l;
                    if (l == 0) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (l == 1) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    }
                    if (dp[i][j] && max <= l) {
                        max = l;
                        start = i;
                        end = j;
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }

    // TODO: 2021/3/19 中心扩展法：参考官方代码，自己想不出来
    static class Solution_2{
        public String longestPalindrome(String s) {
            int len = s.length();
            int max = 1, start = 0, end = 0;
            for (int i = 0; i < len; ++i) {
                int m = extendCenter(s, i, i);
                int n = extendCenter(s, i, i + 1);
                m = Math.max(m, n);
                if (max < m) {
                    max = m;
                    start = i - (m - 1) / 2 ;
                    end = start + max;
                }
            }
            return s.substring(start, end);
        }

        private int extendCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
            }
            return right - left -1;
        }
    }
}
