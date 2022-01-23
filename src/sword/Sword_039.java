package sword;

import java.util.HashMap;

public class Sword_039 {

    public static void main(String[] args) {
        Solution_a solution_a = new Solution_a();
        int[] inputs = {2, 3, 1, 8, 9, 0, 5};
        solution_a.sort(inputs, 0, inputs.length - 1);
        for (int i : inputs) {
            System.out.print(i);
            System.out.print(',');
        }
    }

    /**
     * 宇宙超级无敌朴素做法：用map存储，并实时判断新添加的键值对超过了一半没有
     * （其实临界情况还是需要判断一下，还是有一点细节的）
     */
    static class Solution {
        public int majorityElement(int[] nums) {
            int conditional_num = (nums.length + 1) / 2;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(nums[0], 1);
            for (int i = 1; i < nums.length; i ++) {
                if (map.containsKey(nums[i])) {
                    int count = map.get(nums[i]) + 1;
                    if (count >= conditional_num)
                        return nums[i];
                    map.put(nums[i],  count);
                } else{
                    map.put(nums[i], 1);
                }
            }
            return nums[0];
        }
    }


    /**
     * 官方做法，先排序，返回中值即可。
     * 原因：题目保证肯定有一个数n出现的次数超过数组总数的一半，易证中位数m就是这个数n。
     * 缺点：时间复杂度略高..., 这个方法不太好。
     */
    static class Solution_a {
        public int majorityElement(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return nums[(nums.length + 1) / 2 - 1];
        }

        public void sort(int[] nums, int start, int end) {
            if (start >= end)
                return;
            int pivotKey = nums[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && nums[j] >= pivotKey) j--;
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] <= pivotKey) i++;
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = pivotKey;
            sort(nums, start, i - 1);
            sort(nums, i + 1, end);
        }
    }

    // TODO: 2021/6/17 分治算法
    static class Solution_b {
        public int majorityElement(int[] nums) {
            return 0;
        }
    }

    /**
     * Boyer-Moore 摩尔投票算法
     */
    static class Solution_c {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;
            for (int ele : nums) {
                if (count == 0) {
                    candidate = ele;
                    count = 1;      // 原来使用 count ++，思考后觉得不如赋值运算快！
                } else {
                    if (candidate == ele) {
                        count++;
                    } else {
                        count --;
                    }
                }
            }
            return candidate;
        }
    }





}
