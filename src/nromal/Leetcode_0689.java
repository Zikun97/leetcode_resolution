package nromal;

import java.util.Arrays;

public class Leetcode_0689 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 2, 6, 7, 5, 1,};
        int k = 2;
        Solution_0 solution = new Solution_0();
        System.out.println(Arrays.toString(solution.maxSumOfThreeSubarrays(nums, k)));
    }


    /**
     * 题目：三个无重叠子数组
     */


    /**
     * 想法一： 先利用树状数组来计算区间和，然后进行遍历 (xxx)
     * 但是我忘记树状数组怎么写了？？？
     * 前缀和不是更好？？？
     * (前缀和超时了。。。。。。。。。。。
     * 焯
     */
    static class Solution {
        private long[] vis;
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            // 创建前缀和数组
            vis = new long[nums.length];
            vis[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                vis[i] = nums[i] + vis[i - 1];
            }
            int len = nums.length;
            int a = 0, b = 0, c = 0;
            long ans = (long)Integer.MIN_VALUE * 3 * k;
            for (int i = 0; i <= len - k * 3; ++i) {
                for (int j = i + k; j <= len - k * 2; ++j) {
                    for (int m = j + k; m <= len - k; ++m) {
                        long temp = vis[i + k - 1] - i > 0 ? vis[i - 1]: 0;
                        temp += vis[j + k - 1] - vis[j - 1] + vis[m + k - 1] - vis[m - 1];
                        if ( temp > ans) {
                            ans = temp;
                            a = i;
                            b = j;
                            c = m;
                        }
                    }
                }
            }

            return new int[]{a ,b, c};
        }

        private int log2(int x) {
            return (int)Math.ceil(Math.log((double) x) / Math.log(2.));
        }


        class FenwickTree {
            private int[] tree;
            private int Max;

            public FenwickTree(int max) {
                this.Max = max;
                tree = new int[this.Max + 1];
            }

            private int lowbit(int x) {
                return x & (-x);
            }

            public void update(int x, int n) {
                for (int i = x; i <= this.Max; i += lowbit(i)) {
                    tree[i] += n;
                }
            }

            public int getSum(int x) {
                int ans = 0;
                for (int i = x; i > 0; i -= lowbit(i)) {
//                    System.out.println(i);
                    ans += tree[i];
                }
                System.out.println(ans);
                return ans;
            }
        }
    }

    /**
     * 官方题解：滑动窗口
     */
    static class Solution_0 {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            //
            int temp1 = 0, max1 = 0, max1Idx = 0;
            int temp2 = 0, max12 = 0, max12Idx1 = 0, max12Idx2 = 0;
            int temp3 = 0, max123 = 0;
            int[] ans = new int[3];

            for (int i = 2 * k; i < nums.length; ++i) {
                temp1 += nums[i - 2 * k];
                temp2 += nums[i - k];
                temp3 += nums[i];
                if (i >= 3 * k - 1) {
                    if (temp1 > max1) {
                        max1 = temp1;
                        max1Idx = i - 3 * k + 1;
                    }
                    if (max1 + temp2 > max12) {
                        max12  = max1 + temp2;
                        max12Idx1 = max1Idx;
                        max12Idx2 = i - 2 * k + 1;
                    }
                    if (max12 + temp3 > max123) {
                        max123 = max12 + temp3;
                        ans[0] = max12Idx1;
                        ans[1] = max12Idx2;
                        ans[2] = i - k + 1;
                    }
                    temp1 -= nums[i - 3 * k + 1];
                    temp2 -= nums[i - 2 * k + 1];
                    temp3 -= nums[i - k + 1];
                }
            }
            return ans;
        }
    }


}
