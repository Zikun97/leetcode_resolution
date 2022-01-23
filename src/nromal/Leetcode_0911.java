package nromal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_0911 {


    /**
     * 一种比较朴素的做法
     *
     * 创建二维数组（数组大小为 （times.length, 2））保存times[i]时，胜出者是谁
     *
     * 结果：
     *  时间：超过5.3%
     *  空间：超过98.78%
     */
    static class TopVotedCandidate {

        private int[][] res;
        private Map<Integer, Integer> map = new HashMap<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            res = new int[times.length][2];
            int temp = persons[0];
            int temp_votes = 1;
            map.put(persons[0], map.getOrDefault(persons[0], 0) + 1);
            res[0][0] = times[0];
            res[0][1] = temp;
            for (int i = 1; i < times.length; ++i) {
                if (persons[i] == temp) {
                    ++temp_votes;
                    map.put(temp, temp_votes);
                } else {
                    int m = map.getOrDefault(persons[i], 0) + 1;
                    if (m >= temp_votes) {
                        temp = persons[i];
                        temp_votes = m;
                    }
                    map.put(persons[i], m);
                }

                res[i][0] = times[i];
                res[i][1] = temp;
            }
        }

        public int q(int t) {
            for (int i = 0; i < res.length; ++i) {
                if (t < res[i][0]) {
                    if (i > 0) {
                        return res[i - 1][1];
                    } else {
                        return 0;
                    }
                } else if (t == res[i][0]) {
                    return res[i][1];
                }
            }
            return res[res.length - 1][1];
        }
    }
}
