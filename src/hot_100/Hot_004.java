package hot_100;

import java.math.*;
public class Hot_004 {
    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums1 = { 5, 9}, nums2 = {6};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.print(result);
//        System.out.println(Float.MAX_VALUE);
    }
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len_1 = nums1.length;
            int len_2 = nums2.length;
            int sum = len_1 + len_2;
            int half = sum / 2;
            boolean isEven = sum % 2 == 0;
            int[] nums3 = new int[sum];
            int idx = 0;
            int i, j;
            for (i = 0, j = 0; i < len_1 && j < len_2; ) {
                if (nums1[i] < nums2[j]) {
                    nums3[idx++] = nums1[i++];
                } else{
                    nums3[idx++] = nums2[j++];
                }
                if (idx > half) {
                    if (isEven) {
                        return (nums3[half] + nums3[half-1]) / 2.0;
                    } else {
                        return (nums3[half]);
                    }
                }
            }
            if (i == len_1) {
                for (; j < len_2; ) {
                    nums3[idx++] = nums2[j++];
                    if (idx > half) {
                        if (isEven) {
                            return (nums3[half] + nums3[half-1]) / 2.0;
                        } else {
                            return (nums3[half]);
                        }
                    }
                }
            } else{
                for (; i < len_1; ) {
                    nums3[idx++] = nums1[i++];
                    if (idx > half) {
                        if (isEven) {
                            return (nums3[half - 1] + nums3[half]) / 2.0;
                        } else {
                            return (nums3[half]);
                        }
                    }
                }
            }

        return 0;
        }


    }

    static class Solution_2{
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int len_1 = nums1.length;
            int len_2 = nums2.length;
            int len = len_1 + len_2;
            if (len % 2 == 1) {
                return findKthNum(nums1, nums2, len / 2 + 1);
            } else {
                return (findKthNum(nums1, nums2, len / 2 ) + findKthNum(nums1, nums2, len / 2 + 1)) / 2.0;
            }
        }

        public double findKthNum(int[] nums0, int[] nums1, int k) {
            int len_0 = nums0.length, len_1 = nums1.length;
            int index_0 = 0, index_1 = 0;
            while (true) {

                if (len_0 - index_0 == 0) {
                    return nums1[index_1 + k - 1];
                }
                if (len_1 - index_1 == 0) {
                    return nums0[index_0 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums0[index_0], nums1[index_1]);
                }


                int new_index_0 = Math.min(index_0 + k / 2, len_0) - 1;
                int new_index_1 = Math.min(index_1 + k / 2, len_1) - 1;
                if (nums0[new_index_0] <= nums1[new_index_1]) {
                    k -= new_index_0 - index_0 + 1;
                    index_0 = new_index_0 + 1;
                } else {
                    k -= new_index_1 - index_1 + 1;
                    index_1 = new_index_1 + 1;
                }
            }
        }


    }

    static class Solution_3{
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int left = nums1.length;
            int right = nums2.length;

            int m= nums1.length, n = nums2.length;

            int mdNum1 = 0;
            int mdNum2 = 0;
            int i=0, j = 0;
            while (left <= right) {
                i = (left + right) / 2;
                j = (m + n + 1) / 2;


            }
            return 0;
        }


    }

}


