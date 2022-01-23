package nromal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_0056 {

    /**
     * 题目：合并区间
     */


    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[][]{};
            }
            // 先排序
            // 该题目用左端排序 hes比较合适。
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            List<int[]> ans = new LinkedList<>();

            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; ++i) {
                if (intervals[i][0] <= end) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    ans.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }

            // 添加最后一个
            ans.add(new int[]{start, end});

            return ans.toArray(new int[ans.size()][]);
        }
    }
}
