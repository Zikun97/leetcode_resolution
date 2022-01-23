package nromal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_0851 {

    public static void main(String[] args) {
        List<Integer>[] orders = new List[10];
        for (List<Integer> order : orders) {
            System.out.println(order);
        }
    }

    /**
     * 题目： 喧闹与富有
     */


    /**
     * 思路： 创建一个类似邻接图的数组，然后慢慢遍历。
     * 结果： 超时！！！！
     *
     * 感想： 我是真的笨啊，都邻接图了，怎么没想到图搜索啊啊啊啊啊
     */
    class Solution {
        private List<Integer>[] orders;
        private int[] ans;
        private int[] quiet;
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            this.quiet = quiet;
            int len = quiet.length;
            // orders[i]存储 身价 大于 person[i]的序号
            orders = new List[len];

            // 遍历richer
            for (int[] ele : richer) {
                List<Integer> older = orders[ele[1]];
                if (older == null) {
                    older = new ArrayList<>();
                }
                older.add(ele[0]);
                orders[ele[1]] = older;
            }

            // 生成最后的结果
            ans = new int[len];
            for (int i = 0; i < len; ++i) {
                ans[i] = i;
                List<Integer> list = orders[i];
                if (list == null) {
                    continue;
                }
                for (int idx : list) {
                    if (this.quiet[idx] < this.quiet[ans[i]]) {
                        ans[i] = idx;
                    }
                    compare(idx, i);
                }

            }

            return ans;
        }

        public void compare(int idx, int m) {
            if (orders[idx] == null) {
                return;
            }
            List<Integer> list = orders[idx];
            for (int ele : list) {
                if (this.quiet[ele] < quiet[ans[m]]) {
                    ans[m] = ele;
                }
                compare(ele, m);
            }
        }
    }


    /**
     * 解法一： 图搜索--深度优先搜索
     *  非官方解法
     *  结果：
     *     效率：5.58
     *     时间：26.05
     *  结论： 拉垮
     */
    static class Solution_0 {

        private int[] quiet;
        // 邻接数组
        private List<Integer>[] orders;

        private int[] ans;
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            this.quiet = quiet;
            orders = new List[quiet.length];

            // 生成邻接数组
            for (int[] pair : richer) {
                List<Integer> list = orders[pair[1]];
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(pair[0]);
                orders[pair[1]] = list;
            }

            // 生成最终结果
            ans = new int[quiet.length];

            for (int i = 0; i < quiet.length; ++i) {
                ans[i] = i;
                Set<Integer> vis = new HashSet<>();
                dfs(vis, i, i);
            }
            return ans;
        }

        public void dfs(Set<Integer> vis, int idxA, int idxB) {
            if (orders[idxA] == null) {
                return;
            }

            for (int ele : orders[idxA]) {
                if (vis.contains(ele)) {
                    continue;
                }
                if (quiet[ele] < quiet[ans[idxB]]) {
                    ans[idxB] = ele;
                }
                vis.add(ele);
                dfs(vis, ele, idxB);
            }
        }
    }



}
