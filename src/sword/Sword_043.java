package sword;

public class Sword_043 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(1410065408));
    }

    /**
     * 最开始的朴素想法是打表，但是看到最后数据量最大为2^31，遂放弃
     * 大佬的思路：按位计算1个数
     * 效率: 100; 19.57
     */
    static class Solution {
        public int countDigitOne(int n) {
            int res = 0;
            long devided = 1;
            long cur = (n / devided) % 10;
            long high = n / (devided * 10), low = 0;
            while (devided <= n) {
                System.out.println(cur);
                if (cur == 0) {
                    res += high * devided;
                } else if (cur == 1) {
                    res += high * devided + low + 1;
                } else {
                    res += (high + 1) * devided;
                }
                devided *= 10;
                cur = n / devided % 10;
                high = n / (devided * 10);
                low = n % devided;
            }
            return res;
        }
    }


    /**
     * 上述只是按照大佬的思路做的，但是代码是自己写的，比较挫
     * 来康康大佬的代码
     * 效率: 100; 83.25
     */
    static class Solution_a {
        public int countDigitOne(int n) {
            int digit = 1, res = 0;
            int high = n / 10, cur = n % 10, low = 0;
            while(high != 0 || cur != 0) {  // 这个判断条件比较好，不用使用long类型防止数据溢出。
                if(cur == 0) res += high * digit;
                else if(cur == 1) res += high * digit + low + 1;
                else res += (high + 1) * digit;
                // low、cur、high的记录方式非常优雅
                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;

//
//            作者：jyd
//            链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
//            来源：力扣（LeetCode）
//            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        }
    }
}
