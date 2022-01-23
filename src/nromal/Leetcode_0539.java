package nromal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Leetcode_0539 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMin("12:40"));
    }
    static class Solution {
        public int findMinDifference(List<String> timePoints) {
            int[] times = new int[timePoints.size()];
            Iterator<String> iterator = timePoints.listIterator();
            int idx = 0;
            while (iterator.hasNext()) {
                String s = iterator.next();
                times[idx++] = getMin(s);
            }
            Arrays.sort(times);
            int min = times[times.length - 1] - times[0];
            for (int i = 1; i < times.length; ++i) {
                min = Math.min(min, times[i] - times[i - 1]);
            }
            min = Math.min(min, times[0] + 24 * 60 - times[times.length - 1]);

            return min;
        }

        public int getMin(String s) {
            return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        }
    }
}
