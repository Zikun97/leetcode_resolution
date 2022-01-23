package nromal;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_0997 {

    class Solution {
        public int findJudge(int n, int[][] trust) {

            int[][] mark = new int[n + 1][2];

            for (int[] ele : trust) {
                mark[ele[0]][0] ++;
                mark[ele[1]][1] ++;
            }

            int ans = -1;

            for (int i = 1; i < mark.length; ++i) {
                if (mark[i][0] == 0 && mark[i][1] == n - 1) {
                    if (ans == -1) {
                        ans = i;
                    } else {
                        return -1;
                    }
                }
            }
            return ans;
        }
    }
}
