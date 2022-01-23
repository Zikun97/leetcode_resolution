package nromal;

public class Leetcode_1576 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "j?qg??b";
        System.out.println(solution.modifyString(s));
    }

    static class Solution {
        public String modifyString(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '?') {
                    for (char ch = 'a'; ch < 'd'; ++ch) {
                        if ((i > 0 && sb.charAt(i - 1) == ch ||
                                (i < s.length() - 1 &&  s.charAt(i + 1) != '?' && s.charAt(i + 1) == ch))) {
                            continue;
                        }
                        sb.append(ch);
                        break;
                    }
                } else {
                    sb.append(s.charAt(i));
                }

            }
            return sb.toString();
        }
    }
}
