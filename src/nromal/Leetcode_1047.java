package nromal;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_1047 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("aaabbbbaa"));
    }

    static class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> stack = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            stack.add(s.charAt(0));
            for (int i = 1; i < s.length(); ++i) {
                if (!stack.isEmpty() && s.charAt(i) == stack.peekLast()) {
                    stack.removeLast();
                } else {
                    stack.addLast(s.charAt(i));
                }
            }
            stack.stream().forEach((a) -> {sb.append(a);});
            return sb.toString();
        }
    }
}
