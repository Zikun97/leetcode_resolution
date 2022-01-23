package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot_015 {
    static public void main(String[] args){
        int[] nums = {0};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(nums);
        for (List<Integer> list : res) {
            for (int m : list) {
                System.out.print(m);
                System.out.print(", ");
            }
            System.out.println();
        }
    }




    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            int len = nums.length;
            // 先快排一遍
            sortNums(nums, 0, len - 1);

            for (int first = 0; first < len; ++first) {
                int start = first + 1, end = len - 1;
                int temp = -nums[first];
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                while (start < end) {
                    if (start > first + 1 && nums[start - 1] == nums[start]) {
                        start ++;
                        continue;
                    }
                    if (end < len - 1 && nums[end + 1] == nums[end]) {
                        end --;
                        continue;
                    }

                    if (nums[start] + nums[end] == temp) {
                        res.add(new ArrayList<>(Arrays.asList(nums[first], nums[start], nums[end])));
                        start ++;
                        end --;
                    } else if (nums[start] + nums[end] < temp) {
                        start++;
                    } else {
                        end --;
                    }


                }

            }

            return res;
        }

        private void sortNums(int[] nums, int start, int end) {
            if (nums == null || start >= end) {
                return;
            }
            int key = nums[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && nums[j] >= key)
                    j --;
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] <= key)
                    i ++;
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = key;
            sortNums(nums, start, i - 1);
            sortNums(nums, i + 1, end);
        }
    }
}
