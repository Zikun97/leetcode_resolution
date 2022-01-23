package nromal;

public class Leetcode_0151 {

    public static void main(String[] args) {
        String s = "  hello   world   !   ";
        String[] strings = s.split(" ");
        for (String str : strings) {
            System.out.println(str.length());
        }
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));
    }

    static class Solution {
        public String reverseWords(String s) {

            String[] strings = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = strings.length - 1; i >= 0; --i) {
                if (strings[i].length() != 0) {
                    sb.append(" ");
                    sb.append(strings[i]);
                }
            }
            sb.delete(0, 1);
            return sb.toString();
        }
    }
}
