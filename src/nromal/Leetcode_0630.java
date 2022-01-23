package nromal;

import java.util.*;

public class Leetcode_0630 {

    /**
     * 题目：课程表三
     */

    /**
     * 我想用类似背包的解决办法，后续可以试试
     */
    class Solution {
        public int scheduleCourse(int[][] courses) {

            // 先对课程进行排序
            Arrays.sort(courses, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });

            List<Integer> list = new ArrayList<>();
            int temp = courses[0][1];
            for (int i = 1; i < courses.length; ++i) {
                if (courses[i][1] != temp) {
                    list.add(courses[i][1]);
                    temp = courses[i][1];
                }
            }

            return 0;
        }
    }


    /**
     * 官方题解：
     */
    class Solution_0 {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a, b) -> {return a[1] - b[1];});

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            // 记录当前所有的时间
            int total = 0;

            for (int[] course : courses) {
                if (total + course[0] < course[1]) {
                    total += course[0];
                    queue.offer(course[0]);
                } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                    total -= queue.poll() - course[0];
                    queue.offer(course[0]);
                }
            }
            return queue.size();
        }
    }
}

