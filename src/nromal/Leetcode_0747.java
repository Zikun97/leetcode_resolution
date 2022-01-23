package nromal;

public class Leetcode_0747 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.dominantIndex(nums));
    }

    static class Solution {
        public int dominantIndex(int[] nums) {
            int max = nums[0];
            int idx = 0;
            int maxB = -1;
            for (int i = 1; i < nums.length; ++i) {
                if (max < nums[i]) {
                    maxB = max;
                    max = nums[i];
                    idx = i;
                } else if(max == nums[i]) {
                    idx = i;
                    maxB = nums[i];
                } else if(maxB < nums[i]) {
                    maxB = nums[i];
                }
            }
            return max / 2 >= maxB ? idx: -1;
        }
    }
}
