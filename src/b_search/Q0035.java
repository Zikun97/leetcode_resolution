package b_search;

public class Q0035 {

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if(target > nums[nums.length - 1])
                return nums.length;

            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
