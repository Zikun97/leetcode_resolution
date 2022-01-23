package hot_100;

public class Hot_031 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 1};
        solution.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }

    }

    static class Solution {
        public void nextPermutation(int[] nums) {

            int left = nums.length - 1;

            while (left > 0 && nums[left - 1] >= nums[left] )
                left --;
            if (left == 0) {
                int mid = (nums.length - 1) / 2;
                for (int i = 0; i <= mid; ++i)
                    swap(nums , i, nums.length - i - 1);
                return;
            }
            int first = nums.length - 1;
            left --;
            while (nums[first] <= nums[left])
                first --;
            swap(nums, left, first);

            left ++;
            int mid = (left + nums.length - 1) / 2;
            for (int i = left; i <= mid; ++i)
                swap(nums , i, nums.length - i - 1 + left);
        }

        private void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }
}
