package nromal;

public class Leetcode_0053 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-3, -2, 0, -1};
        System.out.println(solution.maxSubArray(nums));

    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int temp_sum = 0;
            for (int ele : nums) {
                temp_sum += ele;
                if (temp_sum > max) {
                    max = temp_sum;
                }
                if (temp_sum < 0) {
                    temp_sum = 0;
                }
            }
            return max;
        }
    }

    /**
     * 使用动态规划
     */
    static class Solution0 {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; ++i) {
                dp[i] = Math.max(dp[i - 1], 0) + nums[i];
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;
        }
    }



}
