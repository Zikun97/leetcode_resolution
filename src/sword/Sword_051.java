package sword;

import java.util.Arrays;

public class Sword_051 {

    public static void main(String[] args) {
        int[] nums = {9,4,5,21,4,6,7,2,3};
        Solution solution = new Solution();
        Solution_a solution_a = new Solution_a();
        System.out.println(solution.reversePairs(nums));
        System.out.println(solution_a.reversePairs(nums));

    }


    /**
     * 树状数组解法：树状数组经典应用。
     * （但是效率不太高是怎么回事？）
     *  效率： 11; 24
     */
    static class Solution {
        public int reversePairs(int[] nums) {
            int n = nums.length;
            int[] temp = new int[nums.length];
            System.arraycopy(nums, 0, temp, 0, n);
            Arrays.sort(temp);
            for (int i = 0; i < n; ++i) {
                nums[i] = Arrays.binarySearch(temp, nums[i]) + 1;
            }

            BIT bit = new BIT(n + 1);
            int res = 0;
            for (int i = n - 1; i >= 0; --i) {
                res += bit.query(nums[i] - 1);
                bit.update(nums[i], 1);
            }
            return res;
        }

        static class BIT {
            int[] values;
            int len;

            public BIT(int n) {
                this.len = n;
                values = new int[this.len];
            }

            private int lowbits(int x) {
                return x&-x;
            }

            public void update(int idx, int x) {
                while (idx < this.len) {
                    values[idx] += x;
                    idx += lowbits(idx);
                }
            }

            public int query(int idx) {
                int res = 0;
                while (idx > 0) {
                    res += values[idx];
                    idx -= lowbits(idx);
                }
                return res;
            }
        }
    }


    /**
     * 归并排序： 归并排序比树状数组更适合逆序问题！！！
     * 效率： 99.71; 86.46
     */
    static class Solution_a {

        public int reversePairs(int[] nums) {
            int[] temp = new int[nums.length];
            return mergeSort(nums, 0, nums.length - 1, temp);
        }

        public int mergeSort(int[] nums, int start, int end, int[] temp) {
            if (end <= start)
                return 0;
            int middle = (start + end) / 2;
            int res = mergeSort(nums, start, middle, temp);
            res += mergeSort(nums, middle + 1, end, temp);

            int i = start, j = middle + 1;
            int idx = start;
            while (i <= middle && j <= end) {
                if (nums[i] <= nums[j]) {
                    temp[idx++] = nums[i++];
                } else {
                    temp[idx++] = nums[j++];
                    res += middle + 1 - i;
                }
            }

            while (i <= middle) {
                temp[idx++] = nums[i++];
            }
            while (j <= end) {
                temp[idx++] = nums[j++];
                res += middle + 1 - i;
            }

            for (i = start; i <= end; ++i) {
                nums[i] = temp[i];
            }

            return res;
        }
    }




}
