package sword;

public class Sword_046 {

    public static void main(String[] args) {
        Solution_a solution = new Solution_a();
        String s = "abcd";
        System.out.println(s.substring(0, 2));
        System.out.println(solution.translateNum(506));

    }


    /**
     * 一个简单的深度搜索：
     * 坑点：501中，01不可以相当于1，即只可以翻译成eab，不可以翻译为eb，0可不易忽略。
     * 效率：100; 64.79
     */
    static class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            return trueTranslate(s, 0);
        }

        public int trueTranslate(String nums, int start) {
            if (start >= nums.length() - 1)
                return 1;
            int count = 0;
            count +=  trueTranslate(nums, start + 1);
            if (nums.charAt(start) != '0' && Integer.parseInt(nums.substring(start, start + 2)) < 26 )
                count += trueTranslate(nums, start + 2);
            return count;
        }
    }


    /**
     * 这题应该用动态规划最优-_-
     * 这一个是大佬的思路，不用转换字符串，应该算是最优思路了
     * 效率：
     */

    static class Solution_a {
        public int translateNum(int num) {
            if (num < 10)
                return 1;
            if (num % 100 < 26 && num % 100 > 9)
                return translateNum(num / 100) + translateNum(num / 10);
            else
                return translateNum(num / 10);
        }
    }

    /**
     * LeetCode官方解法：
     * 效率: 100; 96.54
     * 为什么使用了String，所占用的内存反而更少？难道是因为jvm的原因？
     */
    static class Solution_b {
        public int translateNum(int num) {
            String src = String.valueOf(num);
            int p = 0, q = 0, r = 1;
            for (int i = 0; i < src.length(); ++i) {
                p = q;
                q = r;
                r = 0;
                r += q;
                if (i == 0) {
                    continue;
                }
                String pre = src.substring(i - 1, i + 1);
                if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                    r += p;
                }
            }
            return r;
        }
    }

}
