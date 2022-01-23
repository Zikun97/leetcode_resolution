package nromal;

import java.util.*;

public class Leetcode_0039 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 5; ++i) {
            System.out.println(random.nextInt(10));
        }
    }

    /***
     * 题目：组合问题——不限次数
     */

    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();
        private Deque<Integer> temp = new LinkedList<>();
        private int target;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.target = target;
            Arrays.sort(candidates);
            backTracking(candidates, 0, 0);
            return ans;
        }

        private void backTracking(int[] candidates, int idx, int sum) {
            // 简单剪枝
            if (sum > target) {
                return;
            }
            if (sum == target) {
                ans.add(new LinkedList<>(temp));
                return;
            }

            for (int i = idx; i < candidates.length; ++i) {
                // 高级剪枝
                if (sum + candidates[i] <= target) {
                    temp.addLast(candidates[i]);
                    backTracking(candidates, i, sum + candidates[i]);
                    temp.removeLast();
                } else {
                    break;
                }

            }
        }
    }
}
