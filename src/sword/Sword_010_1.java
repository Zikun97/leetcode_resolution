package sword;

public class Sword_010_1 {
    static class Solution {
        private static int[] fibs = new int[102];
        private static int mod = 1000000007;
        static{
            fibs[0] = 0;
            fibs[1] = 1;
            for (int i = 2; i < fibs.length; ++i) {
                fibs[i] = (fibs[i - 1]+ fibs[i - 2]) % mod;
            }
        }
        public int fib(int n) {
            return fibs[n];
        }
    }
}
