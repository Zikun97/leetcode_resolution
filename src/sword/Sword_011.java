package sword;

public class Sword_011 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1};
        System.out.println(solution.minArray(nums));

    }

    static class Solution {
        public int minArray(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return -1;
            }


            int start = 1;
            int len = numbers.length;
            while (start < len) {
                if (numbers[start - 1] <= numbers[start]) {
                    start ++;
                } else {
                    return numbers[start];
                }
            }
            return numbers[0];
        }
    }

}
