package nowcoder.huawei;

import java.util.Scanner;

public class StringMath {

    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String p = scanner.next();
            String s = scanner.next();
            System.out.println(StringMath.isMath(s, p));
        }
    }

    public static boolean isMath(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    System.out.println(i);
                    System.out.println(j);
                } else if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    /**
     * dp[i][j] 代表 s[0:i+1] 与 p[0:j+i] 是否匹配
     * 确定的匹配 match = {s[i] == p[j] || p[j] == '?'}
     * 分类情况  1) p[j] = '*' dp[i][j] = (dp[i][j-1] || dp[i-1][j])
     *          2) match     dp[i][j] = dp[i-1][j-1]
     *          3) false     dp[i][j] = false
     * dp[i][j]
     */
}
