package hot_100;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
public class Hot_003 {

    public static void main(String[] args) {
        String s = "abcabcbb";

        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.print(result);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> charMap = new HashMap<>();
            int head = 0, tail = 0;
            int len = s.length();
            int max_sub_len = -1;
            while (tail < len) {
                if (charMap.containsKey(chars[tail])) {
                    int temp = charMap.get(chars[tail]) + 1;
                    for (int i = head; i < temp; ++i) {
                        charMap.remove(chars[i]);
                    }
                    charMap.put(chars[tail], tail);
                    head = temp;

                } else {
                    charMap.put(chars[tail], tail);
                    if (tail - head > max_sub_len) {
                        max_sub_len = tail - head;
                    }
                }
                tail ++;
            }

            return max_sub_len + 1;
        }
    }

    static class Solution_fast {
        public int lengthOfLongestSubstring(String s) {
            // 记录字符上一次出现的位置
            int[] last = new int[128];
            for(int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int n = s.length();

            int res = 0;
            int start = 0; // 窗口开始位置
            for(int i = 0; i < n; i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index] + 1);
                res   = Math.max(res, i - start + 1);
                last[index] = i;
            }

            return res;
        }
    }
}




