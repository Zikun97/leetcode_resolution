package nromal;

public class Leetcode_0334 {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {
                return false;
            }

            int minA = nums[0];
            boolean second = false;
            int minB = nums[0];

            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] < minA) {
                    minA = nums[i];
                } else if (second && nums[i] < minB && nums[i] > minA) {
                    minB = nums[i];
                }
                if (second) {
                    if (nums[i] > minB) {
                        return true;
                    }
                } else {
                    if (nums[i] > minA) {
                        minB = nums[i];
                        second = true;
                    }
                }
            }
            return false;
        }
    }
}
