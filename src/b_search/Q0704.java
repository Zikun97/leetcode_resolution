package b_search;

public class Q0704 {
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }


    static class Solution_1 {

        public int search(int[] nums, int target) {
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
            if (nums[left] == target)
                return left;
            return -1;
        }
    }

}

