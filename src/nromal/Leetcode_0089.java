package nromal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_0089 {

    class Solution {
        private List<Integer> list = new LinkedList<>();

        public List<Integer> grayCode(int n) {
            list.add(0);
            list.add(1);
            if (n == 1) {
                return list;
            }
            for (int i = 1; i < n; ++i) {
                int temp = (int)Math.pow(2, i);
                int size = list.size();
                for (int j = size - 1; j >= 0; --j) {
                    list.add(list.get(j) + temp);
                }
            }
            return list;
        }
    }


    static class Solution_0 {

        static public List<Integer> list = new ArrayList<>();
        static {
            list.add(0);
            list.add(1);
            for (int i = 1; i < 16; ++i) {
                int temp = (int)Math.pow(2, i);
                int size = list.size();
                for (int j = size - 1; j >= 0; --j) {
                    list.add(list.get(j) + temp);
                }
            }
        }


        public List<Integer> grayCode(int n) {
            return list.subList(0, (int) Math.pow(2, n));
        }
    }


    /**
     * 这个解法超级牛皮！！！！
     * （摘自评论区）
     */
    static class Solution_1 {
        public List<Integer> grayCode(int n) {
            /**
             关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
             如 n = 3:
             G(0) = 000,
             G(1) = 1 ^ 0 = 001 ^ 000 = 001
             G(2) = 2 ^ 1 = 010 ^ 001 = 011
             G(3) = 3 ^ 1 = 011 ^ 001 = 010
             G(4) = 4 ^ 2 = 100 ^ 010 = 110
             G(5) = 5 ^ 2 = 101 ^ 010 = 111
             G(6) = 6 ^ 3 = 110 ^ 011 = 101
             G(7) = 7 ^ 3 = 111 ^ 011 = 100
             **/
            List<Integer> ret = new ArrayList<>();
            for(int i = 0; i < 1<<n; ++i) {
                ret.add(i ^ i>>1);
            }
            return ret;
        }
    }
}
