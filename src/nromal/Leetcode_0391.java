package nromal;

import java.util.HashMap;
import java.util.Map;

/**
 题目：完美矩形
 */
public class Leetcode_0391 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(solution.isRectangleCover(rectangles));
    }

    static class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
            int c = Integer.MIN_VALUE, d = Integer.MIN_VALUE;
            Map<Point, Integer> map = new HashMap<>();
            long square = 0;
            for (int[] ele : rectangles) {
                a = Math.min(ele[0], a);
                b = Math.min(ele[1], b);
                c = Math.max(ele[2], c);
                d = Math.max(ele[3], d);

                Point p1 = new Point(ele[0], ele[1]);
                Point p2 = new Point(ele[0], ele[3]);
                Point p3 = new Point(ele[2], ele[3]);
                Point p4 = new Point(ele[2], ele[1]);
                map.put(p1, map.getOrDefault(p1, 0) + 1);
                map.put(p2, map.getOrDefault(p2, 0) + 1);
                map.put(p3, map.getOrDefault(p3, 0) + 1);
                map.put(p4, map.getOrDefault(p4, 0) + 1);
                square += (long) (ele[2] - ele[0]) * (ele[3] - ele[1]);
            }

            Point p1 = new Point(a, b);
            Point p2 = new Point(a, d);
            Point p3 = new Point(c, d);
            Point p4 = new Point(c, b);

//            map.put(p1, map.getOrDefault(p1, 0) + 1);
////            map.put(p2, map.getOrDefault(p2, 0) + 1);
////            map.put(p3, map.getOrDefault(p3, 0) + 1);
////            map.put(p4, map.getOrDefault(p4, 0) + 1);

            if (square != (long) (c - a) * (d - b) || map.getOrDefault(p1, 0) != 1
                    || map.getOrDefault(p2, 0) != 1 || map.getOrDefault(p3, 0) != 1
                    || map.getOrDefault(p4, 0) != 1 ) {
                return false;
            }

            map.remove(p1);
            map.remove(p2);
            map.remove(p3);
            map.remove(p4);

            for (Map.Entry<Point, Integer> ele : map.entrySet()) {
                if (ele.getValue() != 2 && ele.getValue() != 4) {
                    return false;
                }
            }

            return true;
        }
    }

    static class Point {
        public int x;
        public int y;

        public Point() {}

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                return this.x == ((Point) obj).x && this.y == ((Point) obj).y;
            }
            return false;
        }
    }

}
