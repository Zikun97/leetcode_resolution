package nromal;

import sun.nio.cs.ext.MacHebrew;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_0763 {

    public static void main(String[] args) {

    }

    /**
     * 题目：划分字母区间
     *  贪心！
     */

    static class Solution {
        public List<Integer> partitionLabels(String s) {
            // 存储每个元素的最后出现位置
            int[] indexes = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                    indexes[s.charAt(i) - 'a'] = i + 1;
            }

            List<Integer> ans = new LinkedList<>();
            int idx = 0;
            int len = 1;
            while (idx < s.length()) {
                int start = idx;
                len = indexes[s.charAt(idx) - 'a'];
                for (++idx; idx < len; ++idx) {
                    len = Math.max(len, indexes[s.charAt(idx) - 'a']);
                }
                ans.add(len - start);
            }
            return ans;
        }
    }
}
