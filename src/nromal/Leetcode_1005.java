package nromal;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

public class Leetcode_1005 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2, -3, -4};
        int k = 4;
        System.out.println(solution.largestSumAfterKNegations(nums, k));
    }
    /**
     * 题目：K次取反后最大化的数组和
     */

    static class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            // 排序
            Arrays.sort(nums);

            int negatives = 0;
            for (;negatives < nums.length; ++negatives) {
                if (nums[negatives] >= 0) {
                    break;
                }
            }

            int ans = 0;
            if (k <= negatives) {
                for (int i = 0; i < nums.length; ++i) {
                    if (i < k) {
                        ans -= nums[i];
                    } else {
                        ans += nums[i];
                    }
                }
            } else {
                for (int i : nums) {
                    ans += Math.abs(i);
                }
                // 如果存在必须取反的操作
                if (((k - negatives) & 1) == 1)  {
                    if (negatives == nums.length || nums[negatives] != 0) {
                        if (negatives > 0) {
                            ans -= 2 * Math.min(Math.abs(nums[negatives - 1]), Math.abs(nums[Math.min(negatives, nums.length - 1)]));
                        } else {
                            ans -= 2 * Math.abs(nums[Math.min(negatives, nums.length - 1)]);
                        }
                    }
                }
            }
            return ans;
        }
    }


    /**
     * 这个才是贪心做法，每次都更改当前最小的数字
     */
    static class Solution0 {
        public int largestSumAfterKNegations(int[] nums, int k) {
            // 映射数组
            int[] reflect = new int[201];
            int min = 101;
            for (int ele : nums) {
                ++reflect[ele + 100];
                if (ele < min) {
                    min = ele;
                }
            }
            min += 100;
            int ans = 0;
            while (k > 0) {
                while (reflect[min] == 0) {
                    ++min;
                }
                reflect[min] --;
                reflect[200 - min] ++;
                if (min > 100) { // 这一步非常重要，如果当前值为正值，则取反后的值为负值，需要重新调整大小
                    min = 200 - min;
                }
                --k;
            }
            for (int i = 0; i < reflect.length; ++i) {
                if (reflect[i] > 0) {
                    ans += (i - 100) * reflect[i];
                }
            }
            return ans;
        }
    }
}

