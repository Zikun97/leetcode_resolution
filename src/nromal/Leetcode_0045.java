package nromal;

import sun.nio.cs.ext.MacHebrew;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0045 {

    public static void main(String[] args) {
        Solution0 solution = new Solution0();
        int[] nums = {2};
        System.out.println(solution.jump(nums));
    }

    /**
     * 题目：跳跃游戏
     * start: 15:35
     * end: 16:01
     * error
     */

    static class Solution {
        public int jump(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int times = 1;
            int start = 0;
            int end = nums[0];
            int position = nums[0];
            if (position + 1 >= nums.length) {
                return 1;
            }
            while (position + 1 < nums.length) {
                ++ times;
                for (int i = start; i <= end; ++i) {
                    if (position < i + nums[i]) {
                        position = i + nums[i];
                    }
                }
                if (position + 1 >= nums.length) {
                    return times;
                }
                start = end + 1;
                end = position;
            }
            return times;
        }
    }


    /**
     * 官方解法
     */
    static class Solution0 {
        public int jump(int[] nums) {
            int position = 0;
            int end = 0; // 当前step可以到达的最远位置
            int steps = 0;
            for (int i = 0; i < nums.length - 1; ++i) {
                // 遍历到当前点，可以到达的最远距离
                position = Math.max(position, i + nums[i]);
                // 如果当前点已经到达最远距离
                if (i == end) {
                    ++ steps;
                    end = position;
                }
            }
            return steps;
        }
    }
}
