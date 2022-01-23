package sword;


import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Sword_058_1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "  hello world!  ";
        String result = solution.reverseWords(s);
        System.out.println(result);
        System.out.println(result.charAt(0));
    }

    /**
     * 使用Deque<String>来进行操作
     */
    static class Solution {
        public String reverseWords(String s) {
            Deque<String> stack = new LinkedList<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == ' ') {
                    if (sb.length() > 0) {
                        stack.add(sb.toString());
                        sb.delete(0, sb.length());
                    } else
                        continue;;
                } else {
                    sb.append(s.charAt(i));
                }
            }

            if (sb.length() > 0) {
                stack.add(sb.toString());
                sb.delete(0, sb.length());
            }

            for (int i = stack.size() - 1; i  >= 0; --i) {
                sb.append(stack.pollLast());
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);

            return sb.toString();
        }
    }
}
