package sword;

public class Sword_014_2 {

    static class Solution {

        static public int[] res = new int[1001];
        static public int mod = 1000000007;

        static{
            res[2] = 1;
            res[3] = 2;
            for (int i = 4; i < 1001; ++i) {
                int m = i / 3;
                int n = i % 3;
                if (n == 0) {
                    res[i] = (int)pow(3, m, mod);
                } else if (n == 1) {
                    res[i] = (int)(pow(3, m - 1, mod) * 4 % mod);
                } else {
                    res[i] = (int)(pow(3, m, mod) * 2 % mod);
                }
            }
        }

        public int cuttingRope(int n) {
            return res[n];
        }

        public static long pow(int x, int y, int mod) {
            long ans = 1;
            long base = x;
            while (y > 0) {
                if ((y & 1) == 1) {
                    ans = ans * base % mod;
                }
                base = base * base % mod;
                y >>= 1;
            }
            return ans;
        }
    }
}
