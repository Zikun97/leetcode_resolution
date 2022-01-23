package nromal;

import java.util.*;

public class Leetcode_0040 {

    /**
     * 题目：组合2
     * 给定数组可能会
     */

    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();
        private Deque<Integer> temp = new LinkedList<>();
        private int target;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            this.target = target;
            // 先排序
            Arrays.sort(candidates);
            // 回溯算法
            backTracking(candidates, 0, 0);
            return ans;
        }

        private void backTracking(int[] candidates, int idx, int sum) {
            if (sum == target) {
                ans.add(new LinkedList<>(temp));
                return;
            }
            for (int i = idx; i < candidates.length; ++i) {
                if (sum + candidates[i] > target) {
                    break;
                }
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.addLast(candidates[i]);
                backTracking(candidates, i + 1, sum + candidates[i]);
                temp.removeLast();
            }
        }
    }
}
