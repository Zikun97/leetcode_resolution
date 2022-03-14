package hot_100;

import java.util.Deque;
import java.util.LinkedList;

public class Hot_042 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = solution.trap(height);
        System.out.println(result);
    }

    /**
     * 单调栈
     */
    static class Solution {
        public int trap(int[] height) {
            Deque<Integer> stack = new LinkedList<>();
            stack.add(0);
            int result = 0;
            int m = -1;
            for (int i = 1; i < height.length; ++i) {
                while (!stack.isEmpty() && height[stack.getLast()] <= height[i]) {
                    if (m != -1) {
                        result += (Math.min(height[stack.getLast()], height[i]) - m) * (i - stack.getLast() - 1);
                    }
                    m = height[stack.getLast()];
                    stack.removeLast();
                }
                if (!stack.isEmpty() && m != -1) {
                    result += (Math.min(height[stack.getLast()], height[i]) - m) * (i - stack.getLast() - 1);
                }
                m = -1;
                stack.addLast(i);
            }
            return result;
        }
    }
}
