package nromal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_2104 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,-2,-3,4,1};
        System.out.println(solution.subArrayRanges(nums));

    }

    /**
     * 遍历数组
     */
    static class Solution {
        public long subArrayRanges(int[] nums) {
            long ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                int min = nums[i];
                int max = nums[i];
                for (int j = i + 1; j < nums.length; ++j) {
                    if (min > nums[j]) {
                        min = nums[j];
                    }
                    if (max < nums[j]) {
                        max = nums[j];
                    }
                    ans += max - min;
                }
            }
            return ans;
        }
    }

    /**
     * 单调栈
     */

}
