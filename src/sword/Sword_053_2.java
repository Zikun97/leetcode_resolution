package sword;

import netscape.security.UserTarget;

public class Sword_053_2 {

    public static void main(String[] args) {
        Solution_a solution = new Solution_a();
        int[] nums = new int[]{0};
        System.out.println(solution.missingNumber(nums));
    }

    /**
     * 朴素做法
     * 效率：6.73; 29.88
     */
    static class Solution {
        public int missingNumber(int[] nums) {
            int temp = -1;
            for (int ele : nums) {
                if (temp == ele)
                    continue;
                if (ele - temp == 1)
                    temp = ele;
                else
                    break;
            }
            return temp + 1;
        }
    }


    /**
     * 二分做法
     */
    static class Solution_a {
        public int missingNumber(int[] nums) {
            return find(nums, 0, nums.length - 1);
        }

        public int find(int[] nums, int start, int end) {
            if (start > end)
                return start;

            int media = (start + end) / 2;
            if (nums[media] == media)
                return find(nums, media + 1, end);
            else
                return find(nums, start, media - 1);
        }
    }
}
