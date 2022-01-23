package nromal;

public class Leetcode_0367 {

    class Solution {
        public boolean isPerfectSquare(int num) {
            int len = num / 2;
            for (int i = 0; i <= len; ++i) {
                if (num / i == i && num % i  == 0) {
                    return true;
                }
                if (num / i < i) {
                    return false;
                }
            }
            return false;
        }
    }
}
