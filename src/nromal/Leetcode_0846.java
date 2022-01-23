package nromal;

import java.util.Arrays;

public class Leetcode_0846 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] hand = {9,13,15,23,22,25,4,4,29,15,8,23,12,19,24,17,18,11,22,24,17,17,10,23,21,18,14,18,7,6,3,6,19,11,16,11,12,13,8,26,17,20,13,19,22,21,27,9,20,15,20,27,8,13,25,23,22,15,9,14,20,10,6,5,14,12,7,16,21,18,21,24,23,10,21,16,18,16,18,5,20,19,20,10,14,26,2,9,19,12,28,17,5,7,25,22,16,17,21,11};
//        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 10;
        System.out.println(solution.isNStraightHand(hand, groupSize));
    }

    /**
     * 题目： 一手顺子
     */


    /**
     *  解法： 排序 + 压缩数组
     *  （其实也是贪心的思想）
     */
    static class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            // 先判断长度够不够
            if (hand.length % groupSize != 0) {
                return false;
            }

            // 排序
            Arrays.sort(hand);
            System.out.println(Arrays.toString(hand));

            // 压缩数组
            // 根据题目限定条件可知hand的长度为1e4，申请一个数组的长度为2e4
            int[] indices = new int[2 * hand.length + 2];
            int idx = 0;
            int len = 1;
            int value = hand[0];
            indices[0] = 1;
            for (int i = 1; i < hand.length; ++i) {
                if (hand[i] == value) {
                    ++indices[idx];
                } else if (hand[i] == value + 1) {
                    ++indices[++idx];
                    ++value;
                    ++ len;
                } else {
                    if (len < groupSize) {
                        return false;
                    }
                    idx += 2;
                    ++indices[idx];
                    value = hand[i];
                    len = 1;
                }
            }

            // 按照次序取出
            len = 0;
            int begin = 0;
            int i = 0;
            while (i <= idx){
                if (indices[i] > 0) {
                    --indices[i];
                    ++len;
                    if (indices[i] == 0) {
                        begin = i;
                    }
                } else {
                    if (len != 0 && len < groupSize) {
                        return false;
                    }
                }
                if (len == groupSize) {
                    len = 0;
                    i = begin;
                } else {
                    ++i;
                }

            }
            // 最后一组数据并没有统计！！！！
            return len == 0;
        }
    }

    /**[0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27
     * [1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 6, 5, 6, 6, 5, 5, 3, 3, 2, 2, 1, 1,
     * [0, 0, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 6, 6, 5, 6, 6, 5, 5, 3, 3, 2, 2, 1, 1, (0, 9)
     * [0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 5, 6, 6, 5, 5, 3, 3, 2, 2, 1, 1, (2, 11)
     * [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 5, 6, 6, 5, 5, 3, 3, 2, 2, 1, 1, (3, 12)
     * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 3, 4, 5, 5, 5, 6, 6, 5, 5, 3, 3, 2, 2, 1, 1, (7, 16)
     * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 4, 4, 5, 5, 5, 5, 3, 3, 2, 2, 1, 1, (10, 19)
     * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 3, 3, 4, 4, 4, 4, 3, 3, 2, 2, 1, 1, (12, 21)
     * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, 3, 3, 3, 2, 3, 2, 2, 1, 1, (13, 22)
     * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 1, (14, 23)
     * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 2, 1, 1, (15, 24)
     */

}
