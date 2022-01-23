package nromal;

import sun.nio.cs.ext.MacHebrew;

public class Leetcode_0135 {

    /**
     * 题目：分糖果
     */

    /**
     * 思路一：贪心做法
     * 1、先从左至右，满足一遍
     * 2、再从右至左，满足一遍
     * 3、对应位置的最大值
     */
    class Solution {
        public int candy(int[] ratings) {
            if (ratings.length == 0) {
                return 0;
            }
            // 存储左边的
            int[] left = new int[ratings.length];
            left[0] = 1;
            for (int i = 1; i < ratings.length; ++i) {
                if (ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }

            // 仅用一个变量记录前一个值（因为是从右往左，记录上一个右边的值）
            int preRight = 1;
            // 记录结果
            int ans = left[ratings.length - 1];
            for (int i = ratings.length - 2; i >= 0; --i) {
                if (ratings[i] > ratings[i + 1]) {
                    preRight = preRight + 1;
                } else {
                    preRight = 1;
                }
                // 加入最后的总数
                ans += Math.max(preRight, left[i]);
            }
            return ans;
        }
    }


    /**
     * 另外的一种解法：
     * 记录升序和降序的序列
     *
     */
    class Solution0 {
        public int candy(int[] ratings) {
            if (ratings.length == 0) {
                return 0;
            }
            // 记录升序的长度（注意：非严格升序，等于也算升序）
            int up = 1;
            // 降序的长度（严格降序）
            int down = 0;
            // 记录答案
            int ans = 1;
            // 存储上一个节点的糖果数
            int pre = 1;
            for (int i = 1; i < ratings.length; ++i) {
                // 升序情况
                if (ratings[i] >= ratings[i - 1]) {
                    down = 0;
                    pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                    ans += pre;
                    // 升序的长度与升序序列的最大糖果数相等（虽然是废话，但是有助于理解）
                    up = pre;
                } else { // 降序情况（这里其实未计算上降序序列的首个元素，因为降序序列首个元素也是上个序列的尾元素）
                    ++down;
                    pre = 1;
                    // 如果当前降序长度（忽略了首个元素的）等于升序长度，则首个元素也要加上，否不满足条件
                    // 这里还存在一个 常识： 不可能存在两个连续的降序序列，因为这两个降序序列实际为一个
                    if (down == up) {
                        ++down;
                    }
                    ans += down;
                }
            }
            return ans;
        }
    }
}
