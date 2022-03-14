package nromal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_2049 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] parents = {-1, 2, 0, 2, 0};
        int results = solution.countHighestScoreNodes(parents);
        System.out.println(results);
        System.out.println(Arrays.toString(solution.sum));
    }

    /**
     * 超出时间限制
     */
    static class Solution {

        private List<Integer>[] children;
        private int max = 0;
        private long[] sum;
        int result;
        public int countHighestScoreNodes(int[] parents) {
            children = new ArrayList[parents.length];
            sum = new long[parents.length];
            for (int i = 1; i < parents.length; ++i) {
                if (children[parents[i]] == null) {
                    children[parents[i]] = new ArrayList<>();
                }
                children[parents[i]].add(i);
            }
            dfs(0);
            int temp;
            for (int i = 0; i < parents.length; ++i) {
                temp = 1;
                int root = i;
                while (parents[root] != -1) {
                    root = parents[root];
                }
                if (root != i) {
                    temp *= sum[root] - sum[i];
                }
                if (children[i] != null) {
                    for (int ele : children[i]) {
                        temp *= sum[ele];
                    }
                }
                if (temp > max) {
                    result = 1;
                    max = temp;
                } else if (temp == max) {
                    ++result;
                }
            }

            return result;
        }


        private int dfs(int root) {
            if (children[root] == null) {
                sum[root] = 1;
                return 1;
            }

            int s = 1;
            for (int ele : children[root]) {
                s += dfs(ele);
            }
            sum[root] = s;
            return s;
        }
    }


    static class Solution_0 {
        private List<Integer>[] children;
        private int result = 1;
        private long max = 0;
        private int len = 0;
        public int countHighestScoreNodes(int[] parents) {
            len = parents.length;
            children = new List[parents.length];
            for (int i = 0; i < parents.length; ++i) {
                children[i] = new ArrayList<>();
            }

            for (int i = 1; i < parents.length; ++i) {
                children[parents[i]].add(i);
            }
            dfs(0);
            return result;
        }

        private int dfs(int root) {

            int value = 1;
            long temp = 1;
            int size = len;
            for (int ele : children[root]) {
                int m = dfs(ele);
                value += m;
                temp *= m;
            }
            size -= value;
            if (root != 0) {
                temp *= size;
            }
            if (temp == max) {
                ++result;
            } else if (temp > max) {
                max = temp;
                result = 1;
            }
            return value;
        }
    }
}
