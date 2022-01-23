package nromal;

import java.util.Arrays;

public class Leetcode_0611 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0};
        System.out.println(solution.triangleNumber(nums));
    }

    static class Solution {
        public int triangleNumber(int[] nums) {
            // 首先要进行排序
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                int right = i + 1;
                for (int j = i + 1; j < nums.length; ++j) {
                    while (right < nums.length && nums[i] + nums[j] > nums[right]) {
                        right ++;
                    }
                    ans+= Math.max(right - j - 1, 0);
                }

            }
            return ans;
        }
    }
}
