package sword;

import java.util.Deque;
import java.util.LinkedList;

public class Sword_031 {

    public static void main(String[] args) {
        int[] pushed = {};
        int[] popped = {};
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed, popped));
    }

    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed == null)
                return false;
            int len_0 = pushed.length;
            int len_1 = popped.length;
            int i = 0 , j = 0;
            Deque<Integer> stack = new LinkedList<>();
            while (i < len_0 && j < len_1) {
                stack.addLast(pushed[i++]);
                while (!stack.isEmpty() && stack.peekLast() == popped[j]) {
                    stack.removeLast();
                    j ++;
                }
            }
            return i == len_0 && j == len_1;

        }
    }
}
