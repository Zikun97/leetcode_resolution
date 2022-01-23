package sword;

public class Sword_003 {

    static class Solution {
        public int findRepeatNumber(int[] nums) {
            boolean[] flags = new boolean[100000];
            for (int ele : nums) {
                if (flags[ele]) {
                    return ele;
                } else
                    flags[ele] = true;
            }
            return -1;
        }
    }
}
