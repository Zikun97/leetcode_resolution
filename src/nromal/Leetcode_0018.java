package nromal;

import java.util.*;

public class Leetcode_0018 {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> res =  solution.fourSum(nums, 0);
        System.out.println(res.size());
    }

    static class Solution {


        public List<List<Integer>> fourSum(int[] nums, int target) {

            HashMap<Integer, Integer> map = new HashMap<>();
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int left = j + 1;
                    int right = nums.length - 1;
                    int sum = nums[i] + nums[j];
                    while (left < right) {
                        if (sum + nums[left] + nums[right] > target) {
                            --right;
                        } else if (sum + nums[left] + nums[right] < target) {
                            ++left;
                        } else {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            ans.add(list);
                            while (left + 1 < right && nums[left] == nums[left + 1]) {
                                left ++;
                            }
                            while (right - 1 > left && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            ++left;
                            --right;
                        }

                    }
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j ++;
                    }
                }

                while (i +1 < nums.length && nums[i] == nums[i + 1]) {
                    i ++;
                }
            }
            return ans;
        }
    }
}
