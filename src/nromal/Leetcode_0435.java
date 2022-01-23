package nromal;

import java.util.Arrays;

public class Leetcode_0435 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {
                {1, 100},
                {11, 22},
                {1, 11},
                {2, 12}
        };
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }

    /**
     * 题目： 无重叠区间
     */
    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, ((o1, o2) -> {
                return o1[1] > o2[1]? 1: -1;
            }));
            int ans = 1;
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; ++i) {
                if (intervals[i][0] >= end) {
                    end = intervals[i][1];
                    ++ ans;
                }
            }
            return intervals.length - ans;
        }
    }
}
