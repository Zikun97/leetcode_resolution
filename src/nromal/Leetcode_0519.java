package nromal;

import javafx.util.Pair;

import java.util.*;

public class Leetcode_0519 {


    /**
     * 朴素做法，超内存了
     */
    class Solution {

        List<Pair<Integer, Integer>> deque = new ArrayList<>();
        Random random = new Random();
        int m = 0;
        int n = 0;

        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    deque.add(new Pair<>(i, j));
                }
            }
        }

        public int[] flip() {
            int idx = random.nextInt(deque.size());
            Pair<Integer, Integer> res = deque.get(idx);
            deque.remove(idx);
            return new int[]{res.getKey(), res.getValue()};
        }

        public void reset() {
            deque.clear();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    deque.add(new Pair<>(i, j));
                }
            }
        }
    }


    /**
     * 做法一： 展开为1维数组，加末位映射
     */
    static class Solution_0 {

        private Map<Integer, Integer> map = new HashMap<>();
        private int m = 0;
        private int n = 0;
        private int total = 0;
        private Random random = new Random();


        public Solution_0(int m, int n) {
            this.m = m;
            this.n = n;
            this.total = m * n;
        }

        public int[] flip() {
            int idx = random.nextInt(this.total);
            --total;
            int res = map.getOrDefault(idx, idx);
            // 这一步很重要，因为total也可能是映射过的值
            map.put(idx, map.getOrDefault(total, total));
            return new int[]{res / n, res % n};
        }

        public void reset() {
            map.clear();
            this.total = m * n;
        }
    }
}
