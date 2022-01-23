package sword;

public class Sword_056_1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,2,3};
        System.out.println(solution.singleNumbers(nums)[0]);
        System.out.println(solution.singleNumbers(nums)[1]);
    }


    /**
     * 看第一次完全不会做，完全没想法，太菜了。第一个想法是哈希表，但是空间复杂度完全不符合
     * 标（神）准（仙）解法：异或，一个数子与其本身异或结果等于0
     * 效率：65.10; 18.83
     */
    static class Solution {
        public int[] singleNumbers(int[] nums) {
            // 先对整个数组进行一次异或
            int result = 0;
            for (int ele: nums)
                result ^= ele;
            // 设所求的两个singleNumber分别为x, y
            // 得到结果result = x ^ y
            // 想着对nums分组，要分成两组，一组只含x，一组只含y，且成对出现的数字必须出现在同一组内
            // 通过位运算来分组: x，y不同的位在result=x^y表现为1
            // 按位划分也保证成对出现的数字必定出现在同一组内！
            // 求x&y不同的位
            int m = 1;
            while ((m & result) == 0) {
                m <<= 1;
            }
            int a = 0;
            int b = 0;
            for (int ele : nums) {
                if ((ele & m) == 0) { // 这里用==0 或!=0 比较好
                    a ^= ele;
                } else {
                    b ^= ele;
                }
            }
            return new int[]{a, b};
        }
    }
}
