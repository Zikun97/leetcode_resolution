package nromal;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0150 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            for (String s : tokens) {
                if ("+".equals(s)) {
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.addLast(a + b);
                } else if ("-".equals(s)) {
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.addLast(b - a);
                } else if ("*".equals(s)) {
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.addLast(a * b);

                } else if ("/".equals(s)) {
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.addLast(b / a);
                } else {
                    stack.addLast(Integer.parseInt(s));

                }
            }
            return stack.peekLast();
        }
    }
}
