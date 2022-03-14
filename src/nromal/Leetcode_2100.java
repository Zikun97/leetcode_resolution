package nromal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_2100 {

    public static void main(String[] args) {
        Solution_0 solution = new Solution_0();
        int[] security = {1,1,1,1,1};
        List<Integer> results = solution.goodDaysToRobBank(security, 0);
        System.out.println(results);
    }

    /**
     * 模拟方法: 超时！！！
     */
    static class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            int len = security.length - time;
            List<Integer> results = new ArrayList<>();
            boolean flag = true;
            for (int i = time; i < len; ++i) {
                flag = true;
                for (int m = 1; m <= time; ++m) {
                    if (security[i + m] < security[i + m - 1] || security[i - m] < security[i - m + 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    results.add(i);
                }
            }
            return results;
        }
    }


    /***
     * 动态规划
     */
    static class Solution_0 {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            List<Integer> list = new ArrayList<>();
            int[] right = new int[security.length];
            int[] left = new int[security.length];
            left[0] = 1;
            right[0] = 1;
            for (int i = 1; i < security.length; ++i) {
                if (security[i] >= security[i - 1]) {
                    right[i] = right[i - 1] + 1;
                } else {
                    right[i] = 1;
                }
                if (security[i] <= security[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }
            int len = security.length - time;
            for (int i = time; i < len; ++i) {
                if (left[i] > time && right[i + time] > time) {
                    list.add(i);
                }
            }
            return list;
        }
    }
}
