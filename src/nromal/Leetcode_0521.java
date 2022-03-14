package nromal;

public class Leetcode_0521 {

    /***
     * 脑筋急转弯
     */
    class Solution {
        public int findLUSlength(String a, String b) {
            if (a.equals(b)) {
                return -1;
            }
            return Math.max(a.length(), b.length());
        }
    }
}
