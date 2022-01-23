package nromal;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1078 {


    /**
     * 解法：直接使用api，比较简单
     */
    class Solution {
        public String[] findOcurrences(String text, String first, String second) {

            List<String> results = new ArrayList<>();

            String[] words = text.split(" ");
            for (int i = 0; i < words.length; ++i) {
                if (first.equals(words[i])) {
                    if (i + 2 < words.length && second.equals(words[i + 1])) {
                        results.add(words[i + 2]);
                    }
                }
            }
            return results.toArray(new String[]{});
        }
    }
}
