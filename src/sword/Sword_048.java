package sword;

public class Sword_048 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "asdfljnppoij";
        System.out.println(solution.lengthOfLongestSubstring(a));
    }

    /**
     * 在hot100做过，大佬的解法就是无敌！
     * 效率：98.30; 98.45
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() ==0) return 0;

            boolean[] visited = new boolean[128];
            char[] chars = s.toCharArray();
            int start = 0, end = 0;
            int max = 0;
            while (end < chars.length) {
                if (visited[chars[end]]) {
                    int i = start;
                    for (; i < end; ++i) {
                        visited[chars[i]] = false;
                        if (chars[i] == chars[end])
                            break;
                    }
                    start = i + 1;
                } else {
                    visited[chars[end]] = true;
                    if (end - start + 1 > max)
                        max = end - start + 1;
                    ++end;
                }
            }
            return max;
        }
    }
}
