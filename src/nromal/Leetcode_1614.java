package nromal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_1614 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(()(())())";
        System.out.println(solution.maxDepth(s));
    }

    static class Solution {
        public int maxDepth(String s) {
            int ans = 0;
            int size = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    ++ size;
                    ans = Math.max(ans, size);
                } else if (ch == ')') {
                    --size;
                }
            }

            return ans;
        }
    }
}
