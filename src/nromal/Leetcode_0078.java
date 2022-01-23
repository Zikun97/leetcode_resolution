package nromal;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_0078 {

    /**
     * 问题：子集问题
     */


    /**
     * 第一种解法
     */
    class Solution {
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> temp = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            backTracking(nums, 0);
            return ans;
        }

        private void backTracking(int[] nums, int idx) {
            // 终止条件
            if (idx == nums.length) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            temp.add(nums[idx]);
            backTracking(nums, idx + 1);
            temp.remove(temp.size() - 1);
            backTracking(nums, idx + 1);
        }
    }


    /**
     * 另一种解法
     */
    class Solution0 {
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> temp = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            backTracking(nums, 0);
            return ans;
        }

        private void backTracking(int[] nums, int idx) {
            ans.add(new ArrayList<>(temp));
            // 终止条件
            if (idx >= nums.length) {
                return;
            }

            for (int i = idx; i < nums.length; ++i) {
                temp.add(nums[i]);
                backTracking(nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }





}
