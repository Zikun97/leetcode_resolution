package nromal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_0090 {

    class Solution {

            private List<List<Integer>> ans = new ArrayList<>();
            private List<Integer> temp = new ArrayList<>();

            public List<List<Integer>> subsetsWithDup(int[] nums) {
                Arrays.sort(nums);
                backTracking(nums, 0);
                return ans;
            }

            private void backTracking(int[] nums, int idx) {
                ans.add(new ArrayList<>(temp));
                if (idx >= nums.length) {
                    return;
                }
                for (int i = idx; i < nums.length; ++i) {
                    if (i > idx && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    temp.add(nums[i]);
                    backTracking(nums, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
    }
}
