package nromal;

public class Leetcode_0242 {

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] count_a = new int[26];
            int[] count_b = new int[26];

            // 遍历s
            for (int i = 0; i < s.length(); ++i) {
                count_a[s.charAt(i) - 'a'] ++;
            }
            // 遍历t
            for (int i = 0; i < s.length(); ++i) {
                count_b[t.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; ++i) {
                if (count_a[i] != count_b[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
