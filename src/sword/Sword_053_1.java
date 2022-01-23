package sword;

import java.util.HashMap;
import java.util.Map;

public class Sword_053_1 {

    public static void main(String[] args) {
        Solution_a solution = new Solution_a();
//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {};
        System.out.println(solution.search(nums, 6));
    }

    /**
     * 题目说的是排序数组，大意了！
     */

    /**
     * 朴素做法
     * 效率：28.21; 70.63
     */
    static class Solution {
        public int search(int[] nums, int target) {
            int counter = 0;
            for (int ele : nums) {
                if (ele == target) {
                    ++counter;
                }
            }
            return counter;
        }
    }


    /**
     * 使用二分查找
     * 效率： 100; 23.37
     */
    static class Solution_a {
        public int search(int[] nums, int target) {
            int idx = find(nums, target, 0, nums.length - 1);
            if (idx == -1)
                return 0;
            int counter = 0;
            for (int i = idx; i > -1; --i) {
                if (nums[i] == target)
                    ++counter;
                else
                    break;
            }
            for (int i = idx + 1; i < nums.length; ++i) {
                if (nums[i] == target)
                    ++counter;
                else
                    break;
            }

            return counter;
        }

        public int find(int[] nums, int target, int start, int end) {
            if (start > end)
                return -1;
            int media = (start + end) / 2;
            if (nums[media] == target)
                return media;
            else if (nums[media] > target)
                return find(nums, target, start, media - 1);
            else
                return find(nums, target, media + 1, end);
        }
    }
}
