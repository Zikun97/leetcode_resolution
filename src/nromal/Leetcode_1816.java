package nromal;

public class Leetcode_1816 {

    class Solution {
        public String truncateSentence(String s, int k) {
            int idx = 0;
            int nums = 0;
            for (; idx < s.length(); ++idx) {
                if (s.charAt(idx) == ' ') {
                    ++ nums;
                    if (nums == k) {
                        break;
                    }
                }
            }
            return s.substring(0, idx);
        }
    }
}