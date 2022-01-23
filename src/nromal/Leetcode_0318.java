package nromal;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 题目：最大单词长度乘积
 */
public class Leetcode_0318 {

    public static void main(String[] args) {
        System.out.println(1 << 0);
    }

    /**
     * 解法： 位运算
     *
     */
    class Solution {
        public int maxProduct(String[] words) {
            int len = words.length;
            // 使用位来标注字母是否出现
            int[] mask = new int[len];
            for (int i = 0; i < len; ++i) {
                for (char ch : words[i].toCharArray()) {
//                    int temp = 1 << (ch - 'a');
                    // 如果判断该字母没有出现过，则增加该位的标志
//                    if ((mask[i] & temp) == 0) {
//                        mask[i] += temp;
//                    }
                    // 改为或运算更好
                    mask[i] |= 1 << (ch - 'a');
                }
            }

            int result = 0;

            for (int i = 0; i < len; ++i) {
                for (int j = i + 1; j < len; ++j) {
                    if ((mask[i] & mask[j]) == 0) {
                        if (words[i].length() * words[j].length() > result) {
                            result = words[i].length() * words[j].length();
                        }
                    }
                }
            }
            return result;
        }
    }


    /**
     * 优化方法：
     * 存储相同掩码的字符串的最大长度
     */
    class Solution0 {
        public int maxProduct(String[] words) {
            int len = words.length;
            // 使用哈希表来存储相同掩码字符串的最大长度
            Map<Integer, Integer> map = new HashMap<>();
            int[] masks = new int[len];
            for (int i = 0; i < len; ++i) {
                for (char ch : words[i].toCharArray()) {
                    masks[i] |= 1 << (ch - 'a');
                    if (map.getOrDefault(masks[i], 0) < words[i].length()) {
                        map.put(masks[i], words[i].length());
                    }
                }
            }

            int result = 0;
            Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entrySet) {
                for (Map.Entry<Integer, Integer> entry1 : entrySet) {
                    if ((entry.getKey() & entry1.getKey()) == 0) {
                        result = Math.max(result, entry.getValue() * entry1.getValue());
                    }
                }
            }
            return result;
        }
    }
}
