package nromal;

import java.util.Arrays;

public class Leetcode_0686 {

    public static void main(String[] args) {
        String s = "22abcabd";
        String m = "2abc";
        Solution solution = new Solution();
        int[] next = solution.getNext(s);
        System.out.println(Arrays.toString(next));
        System.out.println(solution.compare(s, m));
    }


    /**
     * 思路： 基本框架使用kmp算法，然后使用再根据情况选择合适的策略来实现该算法
     */
    static class Solution {
        public int repeatedStringMatch(String a, String b) {

            int idx = compare(b, a);
            int ans = 0;

            if (idx >= 0) {
                for (int i = idx - 1, j = a.length() - 1; i >= 0; --i, --j) {
                    if (b.charAt(i) != a.charAt(j)) {
                        return -1;
                    }
                }
                ans += 2;
                int m = idx + a.length();
                for (int i = m; i < b.length(); ++i) {
                    if (b.charAt(i) != a.charAt((i - idx) % a.length())) {
                        return -1;
                    }
                    if ((i - idx) % a.length() == 0) {
                        ++ ans;
                    }
                }
            } else {
                if (a.contains(b)) {
                    return 1;
                }
                String c = a + a;
                if (c.contains(b)) {
                    return 2;
                }
                return -1;
            }

            return ans;
        }


        public int[] getNext(String s) {
            int[] next = new int[s.length()];

            int i = 0, k = -1;
            next[0] = -1;
            while (i < s.length() - 1) {
                if (k == -1 || s.charAt(i) == s.charAt(k)) {
                    ++i;
                    ++k;
                    if (s.charAt(i) == s.charAt(k)) {
                        next[i] = next[k];
                    } else {
                        next[i] = k;
                    }
                } else {
                    k = next[k];
                }
            }
            return next;
        }

        public int compare(String a, String b) {
            int[] next = getNext(b);
            int i = 0, j = 0;
            while (i < a.length() && j < b.length()) {
                if (j == -1 || b.charAt(j) == a.charAt(i)) {
                    ++i;
                    ++j;
                } else {
                    j = next[j];
                }
            }
            if (j >= b.length()) {
                return i - b.length();
            }
            return -1;
        }
    }
}
