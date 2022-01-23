package hot_100;

import java.util.Stack;

public class Hot_020 {

    static class Solution {
        // TODO: 2021/3/31 优化，ascii码 值 匹配括号相差 1或 2
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if ((stack.peek() == '(' && c ==')') || (stack.peek() == '[' && c ==']')
                        || (stack.peek() == '{' && c =='}')) {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }
            return stack.isEmpty();
        }
    }

    static class Solution_01 {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (c == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || stack.peek() != c) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
