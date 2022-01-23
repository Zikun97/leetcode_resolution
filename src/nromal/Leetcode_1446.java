package nromal;

public class Leetcode_1446 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maxPower("cc");
        System.out.println(res);
    }

    static class Solution {
        public int maxPower(String s) {
            int max = 1;
            int temp = 1;
            char pre = s.charAt(0);
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == pre) {
                    ++temp;
                } else {
                    max = Math.max(max, temp);
                    temp = 1;
                    pre = s.charAt(i);
                }
            }
            max = Math.max(max, temp);
            return max;
        }
    }
}
