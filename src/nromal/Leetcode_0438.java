package nromal;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目：
 */
public class Leetcode_0438 {


    /**
     * 朴素做法：就是逐个子串 比较
     * （这个我好想在华为二面遇到过）
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            // 先统计p串的各个字母数量
            int[] p_chars = new int[26];
            for (char ch : p.toCharArray()) {
                p_chars[ch - 'a'] ++;
            }

            List<Integer> result = new ArrayList<>();

            int len = s.length() - p.length();

            for (int i = 0; i < len; ++i) {
                int[] temp = new int[26];
                boolean flag = true;
                for (int j = 0; j < p.length(); ++j) {
                    int val = s.charAt(i + j) - 'a';
                    temp[val] ++;
                    if (temp[val] > p_chars[val]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result.add(i);
                }
            }

            return result;
        }
    }
}
