package nromal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode_0373 {


    /**
     *暴力一发试试
     */
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int lenA = Math.min(k, nums1.length);
            int lenB = Math.min(k, nums2.length);
            int[][] m = new int[lenA * lenB][3];
            int idx = 0;
            for (int i = 0; i < lenA; ++i) {
                for (int j = 0; j < lenB; ++j) {
                    m[idx][0] = nums1[i];
                    m[idx][1] = nums2[j];
                    m[idx][2] = nums1[i] + nums2[j];
                    ++idx;
                }
            }

            Arrays.sort(m, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[2] - o1[2];
                }
            });

            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < k; ++i) {
                List<Integer> temp = new ArrayList<>(2);
                temp.add(m[i][0]);
                temp.add(m[i][1]);
                ans.add(temp);
            }
            return ans;
        }
    }
}
