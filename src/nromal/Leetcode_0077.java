package nromal;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode_0077 {

    /***
     * 題目：组合
     */
    class Solution {
        private List<List<Integer>> ans;
        private List<Integer> path;
        public List<List<Integer>> combine(int n, int k) {
            ans = new ArrayList<>();
            path = new ArrayList<>();
            backTracking(n, k, 1);
            return ans;
        }


        private void backTracking(int n, int k, int idx) {
            // 剪枝
            if (path.size() + (n - idx + 1) < k) {
                return;
            }

            if (path.size() == k) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = idx; i <= n; ++i) {
                path.add(i);
                backTracking(n, k, i + 1);
                path.remove(path.size() - 1);
            }
        }

    }

}
