package nromal;

public class Leetcode_0504 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToBase7(-100));
    }

    static class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            boolean flag = false;
            if (num < 0) {
                flag = true;
                num = - num;
            }
            StringBuilder sb = new StringBuilder();
            while (num != 0) {
                sb.append(num % 7);
                num /= 7;
            }
            if (flag) {
                sb.append('-');
            }
            return sb.reverse().toString();
        }
    }
}
