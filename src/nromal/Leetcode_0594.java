package nromal;

import java.util.Arrays;

public class Leetcode_0594 {

    class Solution {
        public int findLHS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            Arrays.sort(nums);

            int right = 0;
            int left = 0;
            int result = 0;
            while (right < nums.length) {
                int temp = nums[right] - nums[left];
                if (temp > 1) {
                    left ++;
                } else if (temp == 1) {
                    result = Math.max(result, right - left + 1);
                    right++;
                } else {
                    right++;
                }
            }
            return result;
        }
    }
}
