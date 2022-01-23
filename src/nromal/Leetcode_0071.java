package nromal;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Leetcode_0071 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String path = "/home/f";
        System.out.println(solution.simplifyPath(path));
    }

    static class Solution {
        private Deque<String> deque = new LinkedList<>();

        public String simplifyPath(String path) {
            StringBuilder stringBuilder = new StringBuilder();
            char pre = '/';
            for (int i = 0; i < path.length(); ++i) {
                char ch = path.charAt(i);
                if (ch == '/') {
                    if (pre == '/') {
                        continue;
                    }
                    String temp = stringBuilder.toString();
                    stringBuilder.delete(0, temp.length());
                    if ("..".equals(temp)) {
                        if (deque.size() > 0) {
                            deque.removeLast();
                        }
                    } else if (!".".equals(temp)) {
                        deque.addLast(temp);
                    }
                } else {
                    stringBuilder.append(ch);
                }
                pre = ch;
            }
            if (stringBuilder.length() > 0) {
                String temp = stringBuilder.toString();
                stringBuilder.delete(0, temp.length());
                if ("..".equals(temp)) {
                    if (deque.size() > 0) {
                        deque.removeLast();
                    }
                } else if (!".".equals(temp)) {
                    deque.addLast(temp);
                }
            }

            for (String s : deque) {
                stringBuilder.append('/');
                stringBuilder.append(s);
            }
            if (stringBuilder.length() == 0) {
                return "/";
            }
            return stringBuilder.toString();
        }
    }
}
