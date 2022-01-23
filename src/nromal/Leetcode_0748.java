package nromal;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_0748 {

    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            // 统计
            int[] labels = new int[26];
            for (char ch : licensePlate.toCharArray()) {
                if (ch >= 'a' && ch <= 'z') {
                    ++ labels[ch - 'a'];
                } else if (ch >= 'A' && ch <= 'Z') {
                    ++labels[ch - 'A'];
                }
            }

            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            for (int i = 0; i < words.length; ++i) {
                boolean flag = true;
                int[] preds = new int[26];
                for (char ch : words[i].toCharArray()) {
                    ++preds[ch - 'a'];
                }
                for (int idx = 0; idx < preds.length; ++idx) {
                    if (preds[idx] < labels[idx]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return words[i];
                }

            }
            return words[0];
        }
    }
}
