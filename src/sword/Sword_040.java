package sword;

import java.util.Arrays;

public class Sword_040 {

    public static void main(String[] args) {
        int[] a = {2, 1, 6, 3, 9, 0, 3,5};
        Solution_a solution = new Solution_a();
        int[] result = solution.getLeastNumbers(a, 4);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 最简单的做法，sort后输出前k个数，比较暴力。
     */
    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0)
                return new int[]{};
            sort(arr, 0, arr.length - 1);
            int[] result = new int[k];
            for (int i = 0; i < k; ++i) {
                result[i] = arr[i];
            }
            return result;
        }

        public void sort(int[] arr, int start, int end) {
            if (start >= end)
                return;
            int sentry = arr[start];
            int i = start;
            int j = end;
            int count = start;
            while (i < j) {
                while (arr[j] >= sentry && i < j)
                    j --;
                while (arr[i] <= sentry && i < j)
                    i++;
                arr[count] = arr[j];
                arr[j] = arr[i];
                count = i;
            }
            arr[i] = sentry;
            sort(arr, start, i);
            sort(arr, i + 1, end);
        }
    }

    /**
     * 活用快排
     * 效率：99.54，22.50
     */
    static class Solution_a {
        public int[] getLeastNumbers(int[] arr, int k) {
            KSort(arr, 0, arr.length - 1, k);
            return Arrays.copyOf(arr, k);
        }


        public void KSort(int[] nums, int start, int end, int k) {
            if (start >= end) return;
            int i = start, j = end;
            int sentry = nums[start];
            while (i < j) {
                while (i < j && nums[j] >= sentry) j--;
                if (i < j) nums[i++] = nums[j];
                while (i < j && nums[i] <= sentry) i++;
                if (i < j) nums[j--] = nums[i];
            }
            nums[i] = sentry;

            int gap = i - start;

            if (gap == k || gap + 1 == k) {
                return;
            }
            if (gap > k)
                KSort(nums, start, i - 1, k);
            if (gap < k -1)
                KSort(nums, i + 1, end, k - gap - 1);
        }
    }



}
