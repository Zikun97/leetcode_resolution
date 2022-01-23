package sword;

public class Sword_016 {

    public static void main(String[] args) {
        int a = -2147483648;
        long m = a;
        System.out.println( -((long)a));
    }

    static class Solution {
        public double myPow(double x, int n) {
            if (n >= 0)
                return pow(x, n);
            long m = n;
            return 1.0 / pow(x, -m);
        }

        private double pow(double x, long n) {
            double ans = 1.0;
            double base = x;
            while (n > 0) {
                if ((n & 1) == 1) {
                    ans *= base;
                }
                base *= base;
                n >>= 1;
            }
            return ans;
        }
    }
}
