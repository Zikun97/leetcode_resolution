package nromal;

public class Leetcode_0372 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 2147483647;
        int[] b = new int[]{2, 0, 0};
        System.out.println(solution.superPow(a, b));
    }

    static class Solution {
        public int superPow(int a, int[] b) {
            int mod = 1337;
            int len = b.length;
            int base = a;
            int ans = 1;
            for (int i = len - 1; i >= 0; --i) {
                ans = (ans * quickPower(base, b[i], mod)) % mod;
                base = quickPower(base, 10, mod);
            }

            return ans;
        }

        public int quickPower(int base, int exponent, int mod) {
            if (exponent == 0) {
                return 1;
            }
            if (mod == 1) {
                return 0;
            }
            int ans = 1;
            base %= mod;
            while (exponent > 0) {
                if ((exponent & 1) == 1) {
                    ans = (ans * base) % mod;
                }
                base = (base * base) % mod;
                exponent >>= 1;
            }
            return ans;
        }
    }
}
