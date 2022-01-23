package nromal;

public class Leetcode_0520 {


    /**
     * 题目：检测大写字母
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "mL";
        System.out.println(solution.detectCapitalUse(word));
    }

    static class Solution {
        public boolean detectCapitalUse(String word) {
            if (word.length() == 1) {
                return true;
            }
            boolean small = word.charAt(0) >= 'a';
            boolean always = small == (word.charAt(1) >= 'a');
            if (small && !always) {
                return false;
            }
            for (int i = 2; i < word.length(); ++i) {
                boolean temp = word.charAt(i) >= 'a';
                if (always) {
                    if (small != temp) {
                        return false;
                    }
                } else {
                    if (!temp) {
                        return false;
                    }
                }

            }

            return true;
        }
    }
}
