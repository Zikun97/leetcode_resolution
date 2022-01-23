package hot_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hot_017 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "2";
        List<String> test = solution.letterCombinations(digits);
        for (String i : test) {
            System.out.println(i);
        }
    }

    static class Solution {
        static public Map<Character, String> map = new HashMap<>();
        static {
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
        }



        public List<String> letterCombinations(String digits) {
            List<String> results = new ArrayList<>();
            results.add("");
            char[] digs = digits.toCharArray();
            for (char c : digs) {
                List<String> temp_results = new ArrayList<>();
                for (String ele : results) {
                    StringBuilder sb = new StringBuilder(ele);
                    char[] toAdd = map.get(c).toCharArray();
                    for (char i : toAdd) {
                        sb.append(i);
                        temp_results.add(sb.toString());
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                results.clear();
                results.addAll(temp_results);

            }
            if (results.size() == 0) {
                results.add("");
            }

            return results;
        }
    }
}
