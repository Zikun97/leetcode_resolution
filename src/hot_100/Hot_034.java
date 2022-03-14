package hot_100;

import java.util.Arrays;

public class Hot_034 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3,4};
        int target = 6;
        int[] results = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(results));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] results = {-1, -1};
            int start = 0;
            int end = nums.length - 1;
            int media = 0;
            while (start <= end) {
                media = (start + end) / 2;
                if (nums[media] == target) {
                    if (media == 0) {
                        results[0] = 0;
                        break;
                    } else if (nums[media - 1] < target) {
                        results[0] = media;
                        break;
                    } else {
                        end = media - 1;
                    }
                } else if (nums[media] > target) {
                    end = media - 1;
                } else {
                    start = media + 1;
                }
            }
            if (media < nums.length && nums[media] == target) {
                results[0] = media;
                results[1] = media;
            }

            start = media;
            end = nums.length - 1;

            while (start <= end) {
                media = (start + end) / 2;
                if (nums[media] == target) {
                    if (media == nums.length - 1) {
                        results[1] = media;
                        break;
                    } else if (nums[media + 1] > target) {
                        results[1] = media;
                        break;
                    } else {
                        start = media + 1;
                    }
                } else if (nums[media] > target) {
                    end = media - 1;
                } else {
                    start = media + 1;
                }
            }


            return results;
        }
    }
}
