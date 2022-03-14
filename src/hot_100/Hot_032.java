package hot_100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Hot_032 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution_0 solution_0 = new Solution_0();
//        String s = "()(((()()()((((((()()()()()";
        String s = "))())()()())))";
        System.out.println(solution.longestValidParentheses(s));
        System.out.println(solution_0.longestValidParentheses(s));
    }

    static class Solution {
        public int longestValidParentheses(String s) {
            char[] chars = s.toCharArray();
            Deque<Integer> stack = new LinkedList<>();
            boolean[] record = new boolean[chars.length];
            int results = 0;
            int temp = 0;
            for (int i = 0; i < chars.length; ++i) {
                if (chars[i] == '(') {
                    stack.add(i);
                } else {
                    if (stack.isEmpty()) {
                        continue;
                    }
                    record[stack.getLast()] = true;
                    record[i] = true;
                    stack.removeLast();
                }
            }
            for (boolean b : record) {
                if (b) {
                    temp++;
                } else {
                    results = Math.max(temp, results);
                    temp = 0;
                }
            }
            results = Math.max(results, temp);
            return results;
        }
    }


    /**
     * 动态规划方法
     */
    static class Solution_0 {
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            int max = 0;
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    dp[i] = 0;
                } else {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = 2;
                        if (i > 1) {
                            dp[i] += dp[i - 2];
                        }
                    } else if (dp[i - 1] > 0){
                        int idx = i - dp[i - 1] - 1;
                        if (idx >= 0 && s.charAt(idx) == '(') {
                            dp[i] = dp[i - 1] + 2;
                            if (idx > 0) {
                                dp[i] += dp[idx - 1];
                            }
                        }

                    }
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(Arrays.toString(dp));
            return max;
        }
    }

    /**
     * 官方动态规划题解
     */
    static class Solution_1 {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }
    }


    /***
     * 官方题解 栈方法
     */
    static class Solution_2 {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    // 这一步非常的重要，存储一个索引，避免在栈空的时候无法处理下一步
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        // 与刚才的注释呼应
                        // 绝!!!
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }






}
