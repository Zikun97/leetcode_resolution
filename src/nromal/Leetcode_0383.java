package nromal;

public class Leetcode_0383 {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            // 这个代表赎金信的字符串构成
            int[] a = new int[26];
            // 这个代表杂志的字符串构成
            int[] b = new int[26];

            for (char ch : ransomNote.toCharArray()) {
                ++a[ch - 'a'];
            }

            for (char ch : magazine.toCharArray()) {
                ++b[ch - 'a'];
            }

            for (int i = 0; i < 26; ++i) {
                if (a[i] > b[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
