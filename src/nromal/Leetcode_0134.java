package nromal;

public class Leetcode_0134 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {2, 3, 5, 1, 4, 2};
//        int[] cost = {2, 3, 5, 1, 4, 2};
        int[] cost = {2, 4, 4, 3, 4, 2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    /**
     * 题目：加油站
     * start: 15:06
     * end: 15:27
     */
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            // 得出每个站点需要的油量
            for (int i = 0; i < gas.length; ++i) {
                gas[i] = gas[i] - cost[i];
            }
            //
            int dp[] = new int[gas.length];
            int positives = 0;
            int negatives = 0;
            int start = 0;
            dp[0] = gas[0];
            for (int i = 1; i < gas.length; ++i) {
                if (gas[i] >= 0) {
                    positives += gas[i];
                } else {
                    negatives += gas[i];
                }
                if (dp[i - 1] >= 0) {
                    dp[i] = dp[i - 1] + gas[i];
                } else {
                    dp[i] = gas[i];
                    start = i;
                }
            }
            if (positives < negatives) {
                return -1;
            }
            int temp = 0;
            for (int i = start; i < gas.length; ++i) {
                temp += gas[i];
                if (temp < 0) {
                    return -1;
                }
            }
            for (int i = 0; i < start; ++i) {
                temp += gas[i];
                if (temp < 0) {
                    return -1;
                }
            }
            return start;
        }
    }

    /**
     * 这个解法比较好，比较容易理解，贪心算法，局部最优
     */
    static class Solution0 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            // 得出每个站点需要的油量
            int total = 0;
            int cur = 0;
            int start = 0;
            for (int i = 0; i < gas.length; ++i) {
                int temp = gas[i] - cost[i];
                cur += temp;
                total += temp;
                if (cur < 0) {
                    cur =0;
                    start = i + 1;
                }
            }
            if (total < 0) {
                return -1;
            }
            return start;

        }
    }
}
