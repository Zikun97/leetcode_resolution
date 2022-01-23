package nromal;

public class Leetcode_0050 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2., 10));
    }

    static class Solution {
        public double myPow(double x, int n) {
            // 如果这一步不转为long，会出现数据溢出
            long nn = n;
            boolean flag = false;
            if (nn < 0) {
                flag = true;
                nn = -nn;
            }
            double ans = 1.;
            while (nn > 0) {
                if ((nn & 1) == 1) {
                    ans *= x;
                }
                x *= x;
                nn >>= 1;
            }
            if (flag) {
                ans = 1. / ans;
            }
            return ans;
        }
    }
}
