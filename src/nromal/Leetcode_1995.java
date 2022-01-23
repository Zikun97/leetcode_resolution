package nromal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_1995 {

    /**
     * 解法：暴力 这个数据范围比较小，可以直接暴力
     */
    class Solution {
        public int countQuadruplets(int[] nums) {
            int ans = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; i < nums.length; ++j) {
                    for (int k = j + 1; k < nums.length; ++k) {
                        for (int m = k + 1; m < nums.length; ++m) {
                            if (nums[i] + nums[j] + nums[k] == nums[m]) {
                                ans ++;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }


    /**
     * 官方解法：哈希
     * 时间复杂度：O(n^3)
     */
    class Solution_0 {
        public int countQuadruplets(int[] nums) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int c = nums.length - 2; c >= 0; --c) {
                map.put(nums[c + 1], map.getOrDefault(nums[c + 1], 0) + 1);
                for (int b = c - 1; b >= 0; --b) {
                    for (int a = b - 1; a >= 0; --a) {
                        ans += map.getOrDefault(nums[nums[a] + nums[b] + nums[c]], 0);
                    }
                }
            }

            return ans;
        }
    }


    /**
     * 官方题解： 哈希nums[d]-nums[c]
     * 时间复杂度：O(n^2)
     */
    class Solution_1 {
        public int countQuadruplets(int[] nums) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            // 遍历b的值
            for (int b = nums.length - 3; b >= 0; --b) {
                // 将 nums[d] - nums[c]加入map
                for (int d = b + 2; d < nums.length; ++d) {
                    int key = nums[d] - nums[b + 1];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }

                for (int a = b - 1; a >= 0; --a) {
                    if (map.containsKey(nums[a] + nums[b])) {
                        ans += map.get(nums[a] +nums[b]);
                    }
                }
            }
            return ans;
        }
    }
}
