package sword;

public class Sword_050 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cc";
        System.out.println(solution.firstUniqChar(s));
    }

    /**
     * 使用哈希表来记录字母出现次数，然后使用
     * 效率：
     */
    static class Solution {
        public char firstUniqChar(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                count[s.charAt(i) - 'a']++;
            }
            int minIndex = 26;
            int first = s.length();
            for (int i = 0; i < 26; ++i) {
                if (count[i] == 1) {
                    if (s.indexOf((int) 'a' + i) < first) {
                        minIndex = i;
                        first = s.indexOf((int) 'a' + i);
                    }
                }
            }
            if (minIndex == 26)
                return ' ';
            return (char) (minIndex + (int)'a');
        }
    }
}
