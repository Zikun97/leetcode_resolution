package sword;

public class Sword_044 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(34523446));
    }

    /**
     * 这一题我有基本的思路，但是细节问题很难把控，所以代码就写的比较拉垮
     * 效率： 100; 40.32
     */
    static class Solution {
        public int findNthDigit(int n) {
            if (n < 10) {
                return n;
            }
            int[] reference = {9, 189, 2889, 38889, 488889, 5888889, 68888889, 788888889};
            int count = 0;
            while (n > reference[count]) {
                count ++;
                if (count >= reference.length) {
                    break;
                }
            }

            int temp = count > 0 ? n - reference[count - 1]: n;
            int high = temp / (int)((count + 1) * Math.pow(10, count));
            int low = temp % (int)((count + 1) * Math.pow(10, count));
            if (low == 0)
                return 9;
            int m = low / (count + 1);
            int s = low % (count + 1);
            int num = (high + 1) * (int)Math.pow(10, count) + m - 1;

            switch (s) {
                case 0: return num % 10;
                case 1: return (high + 1);
                case 2: return num / (int)Math.pow(10, count - 1) % 10;
                case 3: return num / (int)Math.pow(10, count - 2) % 10;
                case 4: return num / (int)Math.pow(10, count - 3) % 10;
                case 5: return num / (int)Math.pow(10, count - 4) % 10;
                case 6: return num / (int)Math.pow(10, count - 5) % 10;
                case 7: return num / (int)Math.pow(10, count - 6) % 10;
                default:
                    break;
            }

            return 0;
        }
    }

    // TODO: 2021/6/25 去参考一下大佬的代码，自己做的速度太慢了，写着写着思路就断了 
}
