package nromal;

public class Leetcode_0344 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] res = new char[]{'a', 'b', 'c'};
        solution.reverseString(res);
        for (char ch : res) {
            System.out.println(ch);

        }
    }

    static class Solution {
        public void reverseString(char[] s) {
            int len = s.length / 2;
            for (int i = 0, j = s.length - 1; i < len; ++i, --j) {
                s[i] ^= s[j];
                s[j] ^= s[i];
                s[i] ^= s[j];
            }
        }

    }
}
