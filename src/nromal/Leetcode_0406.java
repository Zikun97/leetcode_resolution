package nromal;

import java.util.*;

public class Leetcode_0406 {

    /**
     * 题目：根据身高重建队列
     */


    /**
     * 解法：贪心算法
     * 题目理解：一个人只能看见同样身高或者比他高的人
     * 解法：先按照身高排序，满足局部条件
     */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                }
            });
            List<int[]> list = new LinkedList<>();
            for (int[] p : people) {
                list.add(p[1], p);
            }
            return list.toArray(new int[people.length][]);
        }
    }


    /**
     * 另外一种解法：
     */
    class Solution0 {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });
            int[][] res = new int[people.length][];
            for (int[] p : people) {
                int m = 0;
                for (int i = 0; i < res.length; ++ i) {
                    if (m == p[1]) {
                        res[i] = p;
                        break;
                    }
                    if (res[i] == null) {
                        ++m;
                    }
                }
            }
            return res;
        }
    }
}
