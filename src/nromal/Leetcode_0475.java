package nromal;

import java.util.Arrays;

public class Leetcode_0475 {

    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            // 题目中并没有说明houses和heaters是有序的，需要先进行排序，升序即可
            Arrays.sort(houses);
            Arrays.sort(heaters);

            // 虽然只是一个双指针问题，但是这个比较复杂，特殊情况比较多
            // 之前思路有问题，重新写一遍

            int i = 0;
            int j = 0;
            int ans = 0;
            for (i = 0; i < houses.length; ++i) {
                // 对于每一个house，都应该找到前一个和后一个取暖器的位置。
                while (j < heaters.length - 1 && heaters[j] < houses[i]) {
                    j++;
                }
                int a = Math.abs(heaters[j] - houses[i]);
                if (j > 0) {
                    a = Math.min(a, houses[i] - heaters[j - 1]);
                }
                ans = Math.max(ans, a);
            }

            return ans;
        }
    }
}
