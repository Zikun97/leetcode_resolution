package nromal;

import java.util.*;

public class Leetcode_0793 {

    public static void main(String[] args) {
        int[] temperatures = {3,74,75,71,69,72,76,73};
        Solution_1 solution = new Solution_1();
        int[] res = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> indices = new LinkedList<>();
            Deque<Integer> values = new LinkedList<>();
            int[] results = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; ++i) {
                if (!values.isEmpty()) {

                    while (!values.isEmpty() && temperatures[i] > values.getLast()) {
                        results[indices.getLast()] = i - indices.getLast();
                        values.removeLast();
                        indices.removeLast();
                    }
                    values.addLast(temperatures[i]);
                    indices.addLast(i);
                } else {
                    values.add(temperatures[i]);
                    indices.add(i);
                }
            }
            return results;
        }
    }

    /**
     * 暴力法，反向遍历
     */
    static class Solution_0 {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] results = new int[temperatures.length];
            int[] indices = new int[101];
            Arrays.fill(indices, Integer.MAX_VALUE);
            for (int i = temperatures.length - 1; i >= 0; --i) {
                int temp = temperatures[i];
                int min = Integer.MAX_VALUE;
                for (int j = temp + 1; j < indices.length; ++j) {
                    if (indices[j] != Integer.MAX_VALUE) {
                        min = Math.min(min, indices[j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    results[i] = min - i;
                }
                indices[temp] = i;
            }
            return results;
        }
    }


    /**
     *  单调栈：修改版，只保留索引栈
     */

    static class Solution_1 {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> indices = new LinkedList<>();
            int[] results = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; ++i) {
                while (!indices.isEmpty() && temperatures[i] > temperatures[indices.getLast()]) {
                    results[indices.getLast()] = i - indices.getLast();
                    indices.removeLast();
                }
                indices.add(i);
            }
            return results;
        }
    }



}
