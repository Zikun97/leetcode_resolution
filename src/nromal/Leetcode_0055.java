package nromal;

public class Leetcode_0055 {

    /**
     * 题目：跳跃游戏
     */

    class Solution {
        public boolean canJump(int[] nums) {
            int idx = 0;
            int position = 0;
            while (idx < nums.length && idx <= position) {
                if (idx + nums[idx] > position) {
                    position = idx + nums[idx];
                }
                ++idx;
            }
            return position >= nums.length - 1;
        }
    }
}
