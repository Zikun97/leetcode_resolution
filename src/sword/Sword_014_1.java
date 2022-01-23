package sword;

public class Sword_014_1 {

    static class Solution {

        static public int[] res = new int[59];

        static{
            res[2] = 1;
            res[3] = 2;
            for (int i = 4; i < 59; ++i) {
                int m = i / 3;
                int n = i % 3;
                if (n == 0) {
                    res[i] = (int)Math.pow(3, m);
                } else if (n == 1) {
                    res[i] = (int) Math.pow(3, m - 1) * 4;
                } else {
                    res[i] = (int) Math.pow(3, m) * 2;
                }
            }
        }

        public int cuttingRope(int n) {
            return res[n];
        }
    }
}
