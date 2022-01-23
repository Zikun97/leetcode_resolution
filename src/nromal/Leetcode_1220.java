package nromal;

public class Leetcode_1220 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countVowelPermutation(1);
    }

    static class Solution {
        static public int[] res = new int[2 * 10004];
        static public int[] temp = new int[]{1, 1, 1, 1, 1};
        static public int mod = 1000000007;
        static {
            res[1] = 5;
            int len = 2 * 10000 + 1;
            for (int i = 2; i < len; ++i) {
                int a = ((temp[1] + temp[2]) % mod + temp[4]) % mod;
                int e = (temp[0] + temp[2]) % mod;
                int ii = (temp[1] + temp[3]) % mod;
                int o = temp[2];
                int u = (temp[2] + temp[3]) % mod;
                res[i] = ((a + e) % mod + ((ii + o) % mod + u) % mod) % mod;
                temp[0] = a;
                temp[1] = e;
                temp[2] = ii;
                temp[3] = o;
                temp[4] = u;
            }
        }
        public int countVowelPermutation(int n) {
            for (int i = 1; i < 100; ++i) {
                System.out.println(res[i]);
            }
            return res[n];
        }
    }
}
