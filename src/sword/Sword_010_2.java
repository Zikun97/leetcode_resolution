package sword;

public class Sword_010_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 20; ++i) {
            System.out.println(solution.numWays(i));
        }

    }


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


        public int numWays(int n) {
            return fibs[n + 1];
        }

    }
}
