package sword;

public class Sword_057 {

    public static void main(String[] args) {
        int[] nums = {10, 26, 30, 31, 47, 60};
        Solution solution = new Solution();
        System.out.println(solution.twoSum(nums, 40)[0]);
        System.out.println(solution.twoSum(nums, 40)[1]);
    }

    /**
     * 双指针方法
     * 效率: 90+; 90+;
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    return new int[]{nums[start], nums[end]};
                }
                if (nums[start] + nums[end] > target)
                    --end;
                else
                    ++start;
            }
            return new int[]{};
        }
    }

    // TODO: 2021/7/1 优化思考： 利用模糊搜索确定end位置（模糊二叉树？）
}
