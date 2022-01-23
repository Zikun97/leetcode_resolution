package nromal;

public class Leetcode_0825 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ages = {12, 12};
        System.out.println(solution.numFriendRequests(ages));
    }

    /**
     * 题目： 适龄的朋友
     *
     */

    /***
     * 解法： 哈希，年龄可以映射至[1, 120]
     *      然后使用 shu前缀数组
     */
    static class Solution {
        // 保存前缀和
        private int[] preTable = new int[121];
        public int numFriendRequests(int[] ages) {
            // 先求哈希
            for (int ele : ages) {
                ++ preTable[ele];
            }
            // 再求前缀和
            for (int i = 1; i < preTable.length; ++i) {
                preTable[i] += preTable[i - 1];
            }

            int ans = 0;
            for (int i = 0; i < ages.length; ++i) {
                int low = (ages[i] + 14) / 2;
                int hight = ages[i];
                System.out.println(low);
                System.out.println(hight);
                if (low >= hight) {
                    continue;
                }
                if (ages[i] < 100) {
                    hight = Math.min(100, hight);
                }
                if (ages[i] > low && ages[i] <= hight) {
                    -- ans;
                }
                ans += preTable[hight] - preTable[low];
            }
            return ans;
        }
    }
}
