package nromal;

import java.util.Arrays;

public class Leetcode_0452 {

    /**
     * 题目：用最少数量的箭引爆气球
     */
    class Solution {
        public int findMinArrowShots(int[][] points) {
            // 先排序
            Arrays.sort(points, (o1, o2) -> {return o1[1] > o2[1]? 1: -1;});

            int ans = 1;
            int end = points[0][1];
            for (int[] p : points) {
                if (p[0] > end) {
                    end = p[1];
                    ans += 1;
                }
            }
            return ans;
        }
    }
}
