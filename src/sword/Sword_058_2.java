package sword;

public class Sword_058_2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "lr";
        System.out.println(solution.reverseLeftWords(s, 1));
    }

    static class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }
    }
}
