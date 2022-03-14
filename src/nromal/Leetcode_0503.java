package nromal;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_0503 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,3};
        int[] result = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 单调栈
     */
    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> indices = new LinkedList<>();
            int[] results = new int[nums.length];
            Arrays.fill(results, -1);
            // 这是n 不循环的写法
            int len = nums.length * 2;
            for (int i = 0; i < len; ++i) {
                while (!indices.isEmpty() && nums[i % nums.length] > nums[indices.getLast() % nums.length]) {
                    int idx = indices.getLast() % nums.length;
                    if (results[idx] == -1) {
                        results[idx] = nums[i % nums.length];
                    }
                    indices.removeLast();
                }
                indices.add(i);
            }
            return results;
        }
    }
}
