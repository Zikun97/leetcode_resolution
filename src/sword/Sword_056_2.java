package sword;

public class Sword_056_2 {

    public static void main(String[] args) {
        Solution_a solution = new Solution_a();
        int[] nums = {1,1,6,1};
        System.out.println(solution.singleNumber(nums));
    }

    /**
     * 朴素算法： 哈希表
     * 效率：
     */
    static class Solution {
        public int singleNumber(int[] nums) {
            return 0;
        }
    }

    /**
     * 大佬思路，太强了！（想自己实现，发现过于天真！）
     * 效率：71.34; 83.61
     */
    static class Solution_a {
        public int singleNumber(int[] nums) {
            int[] bits = new int[32];
            int m = 1;
            for (int ele : nums) {
                for (int i = 0; i < 32; ++i) {
                    bits[i] += ele & m;
                    ele >>>= 1;  // >>> 无符号右移
                }
            }
            int res = 0;
            m = 3;
            for (int i = 31; i >=0; --i) {
                res <<= 1;
                System.out.println(res);
                res |= bits[i] % m; // 这里也是绝了！
            }

            return res;
        }
    }




    /**
     * 神级做法：位运算 + 有限状态机
     * 效率：100; 99.43
     * 话不多说，神级思想
     */
    static class Solution_c {
        public int singleNumber(int[] nums) {
            int one = 0, two = 0;
            for (int ele : nums) {
                one = one ^ ele & ~two;
                two = two ^ ele & ~one;
            }
            return one;
        }
    }
}
