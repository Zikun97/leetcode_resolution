package nromal;

public class Leetcode_0859 {

    /**
     * 题目：亲密字符串
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buddyStrings("acccccb"
                , "bccccca");
    }

    static class Solution {
        public boolean buddyStrings(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            int[] indices = new int[3];
            int idx = 0;
            int[] all = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != goal.charAt(i)) {
                    indices[idx++] = i;
                    if (idx > 2) {
                        return false;
                    }
                } else {
                    all[s.charAt(i) - 'a'] ++;
                }
            }

            if (idx == 2) {
                if (s.charAt(indices[0]) == goal.charAt(indices[1]) && s.charAt(indices[1]) == goal.charAt(indices[0])) {
                    return true;
                }
            }
            if (idx == 0) {
                for (int i = 0; i < 26; ++i) {
                    if (all[i] >= 2) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
