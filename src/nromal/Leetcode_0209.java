package nromal;

public class Leetcode_0209 {

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int temp = 0;
            int start = 0;
            int end = 0;
            int min = Integer.MAX_VALUE;
            int sum = nums[0];
            while (end < nums.length) {
                if (target <= sum) {
                    if (min > end - start + 1) {
                        min = end - start +1;
                    }
                    sum -= nums[start];
                    start ++;
                } else {
                    ++ end;
                    if (end < nums.length)
                        sum += nums[end];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}
