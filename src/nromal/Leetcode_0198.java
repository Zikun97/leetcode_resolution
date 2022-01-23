package nromal;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode_0198 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,7,9,3,1};
        System.out.println(solution.rob(nums));
    }

    /**
     * 效率： 100
     */
    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int[] dp = new int[nums.length];
            boolean[] status = new boolean[nums.length];

            dp[0] = nums[0];
            status[0] = true;
            if (nums[0] < nums[1]) {
                dp[1] = nums[1];
                status[1] = true;
            } else {
                dp[1] = dp[0];
            }

            for (int i = 2; i < nums.length; ++i) {
                if (status[i - 1]) {
                    if (dp[i - 1] > dp[i - 2] + nums[i]) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 2] + nums[i];
                        status[i] = true;
                    }
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                    status[i] = true;
                }
            }
            return dp[nums.length - 1];
        }
    }


    /**
     * 更好的转移方程，看过解析
     * 效率： 100
     */
    static class Solution_a {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int first = nums[0], second = Math.max(nums[0], nums[2]);
            for (int i = 2; i < nums.length; ++i) {
                int temp = Math.max(first + nums[i], second);
                first = second;
                second = temp;
            }
            return second;
        }
    }
}
