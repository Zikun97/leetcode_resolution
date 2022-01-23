package nromal;

import java.util.*;

public class Leetcode_0017 {

    /**
     * 题目：电话号码的字母组合
     */
    static class Solution {

        private static final Map<Character, List<Character>> map = new HashMap<>();

        private List<String> ans = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();
        static {
            map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
            map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
            map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
            map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
            map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
            map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
            map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
            map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        }

        public List<String> letterCombinations(String digits) {
            backTracking(digits, 0, digits.length() - 1);
            return ans;
        }

        private void backTracking(String digits, int idx, int end) {
            if (idx == end) {
                ans.add(sb.toString());
                return;
            }

            List<Character> characters = map.get(digits.charAt(idx));
            for (Character character : characters) {
                sb.append(character);
                backTracking(digits, idx + 1, end);
                sb.deleteCharAt(idx);
            }

        }
    }
}
