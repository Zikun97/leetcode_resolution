package nromal;


public class Leetcode_0738 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.monotoneIncreasingDigits(0));
    }

    static class Solution {
        public int monotoneIncreasingDigits(int n) {
            int res = check(n);
            if (res == 0) {
                return n;
            }

            return monotoneIncreasingDigits(n - n % (int)Math.pow(10, res) - 1);
        }

        public int check(int n) {
            String s = String.valueOf(n);
            for (int i = s.length() - 1; i > 0; --i) {
                if (s.charAt(i) < s.charAt(i - 1)) {
                    return s.length() - i;
                }
            }
            return 0;
        }
    }
}
