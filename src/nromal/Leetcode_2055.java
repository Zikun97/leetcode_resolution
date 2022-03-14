package nromal;

import java.util.Arrays;

public class Leetcode_2055 {
    public static void main(String[] args) {

//        String s = "*|*||||**|||||||*||*||*||**|*|*||*";
//        int[][] queries = {{2, 33}};
//                [[2,33],[2,32],[3,31],[0,33],[1,24],[3,20],[7,11],[5,32],[2,31],[5,31],[0,31],[3,28],[4,33],[6,29],[2,30],[2,28],[1,30],[1,33],[4,32],[5,30],[4,23],[0,30],[3,10],[5,28],[0,28],[4,28],[3,33],[0,27]]
//        String s = "***|**|*****|**||**|*";
//        int[][] queries = {{0, 17}, {4, 5}, {14,17},{5,11},{15,16}};
        String s = "*|*|||";
        int[][] queries = {{0,0},{1,3}};
//        String s = "**|**|***|";
//        int[][] queries = {{2, 5}, {5, 9}};
        Solution solution = new Solution();
        Solution_0 solution_0 = new Solution_0();
        Solution_1 solution_1 = new Solution_1();

        int[] results = solution.platesBetweenCandles(s, queries);
        int[] results_0 = solution_0.platesBetweenCandles(s, queries);
        int[] results_1 = solution_1.platesBetweenCandles(s, queries);

        System.out.println(Arrays.toString(results));
        System.out.println(Arrays.toString(results_0));
        System.out.println(Arrays.toString(results_1));

//        int[] nums = new int[40];
//        for (int i = 0; i < nums.length; ++i) {
//            nums[i] = 2 * i;
//        }
//        solution_0.timm = nums;
//        solution_0.idx = nums.length;
//
//        for (int i = 0; i < nums.length; ++i) {
//            System.out.println(solution_0.find(2 * i + 1, 0, nums.length - 1));
//            System.out.println(solution_0.find2(2 * i + 1, 0, nums.length - 1));
//            System.out.println("____________________");
//        }
    }


    /**
     * 前缀树做法，超时
     */
    static class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] record = new int[s.length()];
            int temp = 0;
            int start = s.indexOf('|');
            for (int i = start; i < s.length(); ++i) {
                if (s.charAt(i) == '|') {
                    record[i] = i > 0 ? record[i - 1] + temp : temp;
                    temp = 0;
                } else {
                    ++ temp;
                    record[i] = i > 0 ? record[i - 1]: 0;
                }
            }
//            System.out.println(Arrays.toString(record));
            int[] results = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                int end = queries[i][0];
                for (int j = queries[i][0]; j < queries[i][1]; ++j) {
                    if (s.charAt(j) == '|') {
                        end = j;
                        break;
                    }
                }
                results[i] = record[queries[i][1]] - record[end];
            }
            return results;
        }
    }

    /**
     * 前缀树，用二分查找优化
     * 改了 好长时间，我敲！！！！
     */
    static class Solution_0 {

        private int[] timm;
        private int idx;
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] record = new int[s.length()];
            int temp = 0;
            int start = s.indexOf('|');
            idx = 0;
            timm = new int[s.length()];
            for (int i = start; i < s.length(); ++i) {
                if (s.charAt(i) == '|') {
                    record[i] = i > 0 ? record[i - 1] + temp : temp;
                    temp = 0;
                    timm[idx++] = i;
                } else {
                    ++ temp;
                    record[i] = i > 0 ? record[i - 1]: 0;
                }
            }
            System.out.println(Arrays.toString(record));
            System.out.println(Arrays.toString(timm));
            int[] results = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {

                if (record[queries[i][1]] != record[queries[i][0]]) {
                    int end = queries[i][0];
                    end = find(end, 0, idx - 1);
                    System.out.println(end);
                    results[i] = record[queries[i][1]] - record[timm[end]];
                }
            }
            return results;
        }

        // 就是这里调试了一下午，丢丢丢丢！
        public int find(int n, int start, int end) {
            // 退出条件
            if (start == end) {
                return start;
            }
            if (start > end) {
                if (start >= idx) {
                    return end;
                }
                if (end < 0) {
                    return start;
                }
                if (timm[end] < n) {
                    return start;
                } else {
                    return end;
                }
            }

            int media = (start + end) / 2;

            if (timm[media] == n) {
                return media;
            } else if (timm[media] > n) {
                if (media > 0 && timm[media - 1] < n) {
                    return media;
                }
                return find(n, start, media - 1);
            } else {
                if (media < idx && timm[media + 1] > n) {
                    return media + 1;
                }
                return find(n, media + 1, end);
            }
        }

        public int find2(int n, int start, int end) {
            for (int i = start; i <= end; ++i) {
                if (timm[i] >= n) {
                    return i;
                }
            }
            return end;
        }
    }


    /**
     * 官方题解，主要思想  前缀树 + 预处理
     */
    static class Solution_1 {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int len = s.length();
            int sum = 0;
            int[] preSum = new int[len];
            int[] left = new int[len];
            int[] right = new int[len];
            int temp = -1;
            for (int i = 0; i < len; ++i) {
                if (s.charAt(i) == '*') {
                    ++sum;
                } else {
                    temp = i;
                }
                preSum[i] = sum;
                left[i] = temp;
            }


            temp = -1;
            for (int i = len - 1; i >= 0; --i) {
                if (s.charAt(i) == '|') {
                    temp = i;
                }
                right[i] = temp;
            }
//            System.out.println(Arrays.toString(preSum));
//            System.out.println(Arrays.toString(left));
//            System.out.println(Arrays.toString(right));
            int[] results = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                if (right[queries[i][0]] == -1 || left[queries[i][1]] == -1) {
                    results[i] = 0;
                    continue;
                }
                int l = preSum[left[queries[i][1]]];
                int r = preSum[right[queries[i][0]]];
                results[i] = Math.max(0, l - r);
            }
            return results;
        }
    }
}
