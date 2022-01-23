package nromal;

import java.util.Arrays;

public class Leetcode_0494 {

    /**
     * 题目：目标和
     */

    /**
     * 思路：对于每个数仅可使用加法或者减法，相当于把数组分为两组，两组相减
     * 而对其中一组来说，就是一个背包问题
     *
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {

            int sum = 0;
            for (int ele : nums) {
                sum += ele;
            }
            // 先判定结束条件
            if (Math.abs(target) > sum) {
                return 0;
            }
            // 分为两组，left， right = sum - left
            // left - right = left - (sum - left) = target  =>  left * 2 = sum + target
            // sum + target 必定是偶数，否则无解
            if (((sum + target) & 1) == 1) {
                return 0;
            }

            int left = (sum + target) / 2;

            // dp滚动数组
            // dp[i]：和 为i的组合有几种
            int[] dp = new int[left - 1];

            // 初始化第一行数据
            // 和 为0的选择有1种！！并不是0种
            dp[0] = 1;
            // 选择第一个数
            dp[nums[0]] = 1;

            for (int i = 1; i < nums.length; ++i) {
                for (int j = left; j >= nums[i]; --j) {
                    // 在二维dp数组中，dp[j]相当于dp[i-1][j]
                    // 状态转移方程为 dp[i][j] = dp[i - 1] + dp[i - 1][j - nums[i]]
                    // 在滚动数组中，则为 dp[j] = dp[j] + dp[j - nums[i]]
                    dp[j] += dp[j - nums[i]];
                }
            }

            return dp[left - 1];
        }
    }



    /**
     * 试一试回溯算法
     * TODO: 这个好像有点问题，等稍后再仔细思索
     */
    class Solution0 {
        private int ans = 0;
        private int temp = 0;
        private int left = 0;
        public int findTargetSumWays(int[] nums, int target) {

            int sum = Arrays.stream(nums).sum();
            this.left = (sum + target) / 2;
            this.ans = 0;
            this.temp = 0;
            backTracking(nums, 0);
            return ans;
        }

        private void backTracking(int[] nums, int idx) {
            if (idx == nums.length) {
                if (temp == left) {
                    ++ans;
                }
                return;
            }
            for (int i = idx; i < nums.length; ++i) {
                temp += nums[i];
                backTracking(nums, idx + 1);
                temp -= nums[i];
            }
        }
    }
}
