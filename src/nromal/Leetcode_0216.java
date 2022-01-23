package nromal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_0216 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.printf(solution.combinationSum3(9, 45).toString());
    }

    /**
     * 题目：组合
     */
    static class Solution {

        private List<List<Integer>> ans;
        private Deque<Integer> temp;
//        private boolean[] visited = new boolean[10];

        public List<List<Integer>> combinationSum3(int k, int n) {
            if (k > 9 || n > 45) {
                return new ArrayList<>();
            }
            ans = new ArrayList<>();
            temp = new LinkedList<>();
            backTracking(k, n, 1, 0);
            return ans;
        }

        private void backTracking(int k, int n, int cur, int sum) {


            if (temp.size() == k) {
                if (sum == n) {
                    ans.add(new ArrayList<>(temp));
                }
                return;
            }
            int size = 9 - (k - temp.size()) + 1;
            System.out.println(size);
            for (int i = cur; i <= size; ++i) {
                temp.addLast(i);
                backTracking(k, n, i + 1, sum + i);
                temp.pollLast();
            }
        }
    }
}
