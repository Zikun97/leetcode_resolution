package nromal;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_0376 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{51,
                226,
                208,
                165,
                202,
                286,
                190,
                212,
                219,
                271,
                36,
                245,
                20,
                238,
                238,
                89,
                105,
                66,
                73,
                9,
                254,
                206,
                221,
                237,
                203,
                33,
                249,
                253,
                150,
                102,
                57,
                249,
                203,
                10,
                123,
                178,
                85,
                203,
                35,
                276,
                129,
                116,
                37,
                163,
                99,
                142,
                187,
                249,
                134,
                77,
                217,
                298,
                29,
                127,
                174,
                115,
                122,
                178,
                12,
                80,
                122,
                76,
                16,
                41,
                115,
                84,
                104,
                121,
                127,
                40,
                287,
                129,
                9,
                172,
                112,
                51,
                40,
                135,
                205,
                53,
                259,
                196,
                248,
                5,
                123,
                184,
                209,
                130,
                271,
                42,
                18,
                143,
                24,
                101,
                10,
                273,
                252,
                50,
                173,
                80,
                119,
                129,
                45,
                257,
                299,
                78,
                278,
                78,
                190,
                215,
                284,
                129,
                200,
                232,
                103,
                97,
                167,
                120,
                49,
                298,
                141,
                146,
                154,
                233,
                214,
                196,
                244,
                50,
                110,
                48,
                152,
                82,
                226,
                26,
                254,
                276,
                292,
                286,
                215,
                56,
                128,
                122,
                82,
                241,
                222,
                12,
                272,
                192,
                224,
                136,
                116,
                70,
                39,
                207,
                295,
                49,
                194,
                90,
                210,
                123,
                271,
                18,
                276,
                87,
                177,
                240,
                276,
                33,
                155,
                200,
                51,
                6,
                212,
                36,
                149,
                202,
                48,
                114,
                58,
                91,
                83,
                221,
                175,
                148,
                278,
                300,
                284,
                86,
                191,
                95,
                77,
                215,
                113,
                257,
                153,
                135,
                217,
                76,
                85,
                269,
                126,
                194,
                199,
                195,
                20,
                204,
                194,
                50,
                220,
                228,
                90,
                221,
                256,
                87,
                157,
                246,
                74,
                156,
                9,
                196,
                16,
                259,
                234,
                79,
                31,
                206,
                148,
                12,
                223,
                151,
                96,
                229,
                165,
                9,
                144,
                26,
                255,
                201,
                33,
                89,
                145,
                155,
                1,
                204,
                37,
                107,
                80,
                212,
                88,
                186,
                254,
                9,
                158,
                180,
                24,
                45,
                158,
                100,
                52,
                131,
                71,
                174,
                229,
                236,
                296,
                299,
                184,
                168,
                41,
                45,
                76,
                68,
                122,
                85,
                292,
                238,
                293,
                179,
                143,
                128,
                47,
                87,
                267,
                53,
                187,
                76,
                292,
                0,
                160,
                70,
                172,
                292,
                9,
                64,
                156,
                153,
                26,
                145,
                196,
                222};
        System.out.println(solution.wiggleMaxLength(nums));
        System.out.println(0 ^ 980);
    }
    /**
     * 题目：最长摆动（子）序列
     */

    /**
     * 贪心做法
     */
    static class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length == 0 || nums.length == 1) {
                return nums.length;
            }
            int max = 2;
            // 0, 1 元素做特殊处理
            int preDiff = nums[1] - nums[0];
            if (preDiff == 0) {
                max = 1;
            }
            for (int i = 2; i < nums.length; ++i) {
                int tempDiff = nums[i] - nums[i - 1];
                // 当前值与之前的值有绝对的落差时，才会产生波动
                if ((tempDiff > 0 && preDiff <= 0) || (tempDiff < 0 && preDiff >= 0)) {
                    ++max;
                    // 注意更新时机
                    preDiff = tempDiff;
                }

            }
            return max;
        }
    }

    /**
     * 动态规划做法
     * start: 14:50
     * end:
     */
    class Solution0 {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            // 上摆序列: 序列最后的摆动方向为向上摆
            int up = 1;
            // 下摆序列：序列最后的摆动方向为向下摆
            int down = 1;

            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] > nums[i - 1]) { // 当前节点 小于 前一个节点
                    // 下摆序列并不会增加
                    // 上摆序列可能会发生改变：下摆序列 + 当前节点 又形成了一个新的上摆序列，当然需要比较一下最大长度
                    up = Math.max(up, down + 1);
                } else if (nums[i] < nums[i - 1]) { // 当前节点 大于 前一个节点
                    // 上摆序列并不会增加
                    // 下摆序列可能会发生改变：上摆序列 + 当前节点 又形成了一个新的下摆序列，当然需要比较一下最大长度
                    down = Math.max(down, up + 1);
                }
            }
            return Math.max(up, down);
        }
    }
}