package nromal;


/**
 * 题目： 第N位数字
 */
public class Leetcode_0400 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int re = solution.findNthDigit(9);
        System.out.println(re);
    }

    /**
     * 解法：二分查找
     * 用二分查找来形容该解法，也不尽正确
     * 该解法最核心的内容，其实是规律
     * 1.先确定该数是几位数
     * 2.然后确定n是该数的第几位数字
     *
     * 规律：
     * 1. 一位数数目： 9     相应的数字数目： 9 * 1
     *    二位数数目： 90    相应的数字数目： 90 * 2
     *    三位数数目： 900   相应的数字数目： 900 * 3
     *       ……
     *    n位数数目： 9*10^(n-1) 相应的数字数目： n*9*10*(n-1)
     *
     */
    static class Solution {
        public int findNthDigit(int n) {
            // 确定相应的位数，最多有多少数字
            long[] tag = new long[11];
            for (int i = 1; i < tag.length; ++i) {
                tag[i] = tag[i - 1] + i * 9 * (long)Math.pow(10, i - 1);
            }

            int digit = 1;

            // 确定是几位数
            for (int i = 0; i < tag.length; ++i) {
                if (n <= tag[i]) {
                    digit = i;
                    break;
                }
            }

            // 确定是哪个数字
            int temp = n - (int)tag[digit - 1];
            int number = (int) Math.pow(10, digit - 1) + (temp - 1) / digit;
            int wei = temp % digit;
            if (wei == 0) {
                return number % 10;
            }

            String s = String.valueOf(number);
            return s.charAt(wei - 1) - '0';
        }
    }
}
