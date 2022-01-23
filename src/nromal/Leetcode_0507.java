package nromal;

public class Leetcode_0507 {

    class Solution {
        public boolean checkPerfectNumber(int num) {
            if (num == 1) {
                return false;
            }
            int n = (int) Math.sqrt(num);
            int ans = 1;
            for (int i = 2; i <= n; ++i) {
                if (num % i == 0) {
                    ans += i;
                    int t = num / i;
                    if (i != t) {
                        ans += t;
                    }
                }
            }
            return ans == num;
        }
    }
}
