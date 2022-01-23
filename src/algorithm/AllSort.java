package algorithm;

import java.util.Collections;
import java.util.Random;

public class AllSort {

    static public void main(String[] args) {
        int[] nums = {1, 32, 2, 234, 211, 34, 89};
        AllSort.quickSort_2(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i);
            System.out.print(", ");
        }
    }

    // TODO: 2021/3/25 冒泡排序
    static public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    // TODO: 2021/3/25 选择排序
    static public int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; ++i){
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    // TODO: 2021/3/25 插入排序
    static public int[] insertSort(int[] nums){
//        List<Integer> list = new ArrayList<>();
        return null;
    }

    // TODO: 2021/3/25 希尔排序
    static public int[] hillSort(int[] nums) {
        int gap = nums.length / 2;
        while (gap > 0) {
            for(int i = 0; i < nums.length - gap; ++i) {
                for (int j = i + gap; j < nums.length; ++j){
                    int k = j - gap;
                    if (nums[j] < nums[k]) {
                        int temp = nums[j];
                        nums[j] = nums[k];
                        nums[k] = temp;
                    }
                }
            }
            gap /= 2;
        }
        return nums;
    }

    // TODO: 2021/3/26 归并排序 
    static public int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        merge(nums, 0, nums.length - 1, temp);
        return nums;
    }

    static public void merge(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        merge(nums, left, mid, temp);
        merge(nums, mid + 1, right, temp);
        int i = left, j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[idx ++] = nums[i ++];
            } else {
                temp[idx ++] = nums[j ++];
            }
        }

        while (i <= mid) {
            temp[idx ++] = nums[i ++];
        }

        while (j <= right) {
            temp[idx ++] = nums[j ++];
        }

        for (int k = 0; k < idx; ++k) {
            nums[k + left] = temp[k];
        }
    }

    // TODO: 2021/3/26 快速排序
    static public int[] quickSort(int[] nums, int start, int end) {
        if (start == end) {
            return nums;
        }

        int mid = partition(nums, start, end);
        if (mid > start) {
            quickSort(nums, start, mid);
        }
        if (mid + 1 < end) {
            quickSort(nums, mid + 1, end    );
        }


        return nums;
    }

    public static int partition(int[] nums, int start, int end) {
        int index = start + (int)(Math.random() * (end - start + 1));
        swap(nums, index, end);
        int small = start - 1;
        for (index = start; index < end; ++index) {
            if (nums[index] < nums[end]) {
                small ++;
                if (small != index) {
                    swap(nums, index, small);
                }
            }
        }
        swap(nums, small + 1, end);
        return small + 1;
    }

    public static void swap(int[] nums, int idx_a, int idx_b) {
        int temp = nums[idx_a];
        nums[idx_a] = nums[idx_b];
        nums[idx_b] = temp;
    }

    public static void quickSort_2(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotKey = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= pivotKey) j --;
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= pivotKey) i++;
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivotKey;
        quickSort_2(nums, start, i - 1);
        quickSort_2(nums, i + 1, end);
    }
}
