package sword;

import java.util.Arrays;

public class Sword_017 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.printNumbers(5);
        for (int ele : res) {
            System.out.println(ele);
        }
    }

    static class Solution {
        public int[] printNumbers(int n) {
            int end = 0;
            for (int i = 0; i < n; ++i) {
                end = end * 10 + 9;
            }
            
            int[] res = new int[end];
            int idx = 0;
            while (idx < end) {
                res[idx ++]  = idx;
            }
            return res;
        }
    }
}
