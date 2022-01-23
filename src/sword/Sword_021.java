package sword;

public class Sword_021 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution solution = new Solution();
        solution.exchange(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    static class Solution {

        public int[] exchange(int[] nums) {
            if (nums.length ==0 || nums.length == 1)
                return nums;

            int sentry = nums[0];
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                while (!isOdd(nums[end]) && end > start)
                    end --;
                if (start < end)
                    nums[start ++] = nums[end];
                while (isOdd(nums[start]) && end > start)
                    start ++;
                if (start < end)
                    nums[end --] = nums[start];
            }

            nums[start] = sentry;
            return nums;
        }

        private boolean isOdd(int i) {
            return (i&1) == 1;
        }

    }




}
