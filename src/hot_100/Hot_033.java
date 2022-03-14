package hot_100;

public class Hot_033 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution_0 solution_0 = new Solution_0();
        int[] nums = {4,5,6,7,-2,-1,0,1,2};
        int target = 7;
        int result = solution.search(nums, target);
        System.out.println(result);
        System.out.println(solution_0.search(nums, target));
    }


    /***
     * 二分查找，递归做法
     */
    static class Solution {
        private int anInt;
        private int[] nums;
        public int search(int[] nums, int target) {
            this.anInt = nums[0];
            this.nums = nums;
            return biSearch(target, 0, nums.length - 1);
        }

        public int biSearch(int n, int start, int end) {
            if (start > end) {
                return -1;
            }
            if (start == end) {
                if (nums[start] == n) {
                    return start;
                } else {
                    return -1;
                }
            }
            int media = (start + end) / 2;
            if (nums[media] == n) {
                return media;
            } else if (n > nums[media]) {
                if (nums[media] >= anInt) {
                    return biSearch(n, media + 1, end);
                } else {
                    if (n >= anInt) {
                        return biSearch(n, start, media - 1);
                    } else {
                        return biSearch(n, media + 1, end);
                    }
                }
            } else { // n < nums[media]
                if (n < anInt && nums[media] >= anInt) {
                    return biSearch(n, media + 1, end);
                } else {
                    return biSearch(n, start, media - 1);
                }
            }
        }
    }

    /***
     * 二分查找，迭代做法
     */
    static class Solution_0 {
        public int search(int[] nums, int target) {
            int anInt = nums[0];
            int start = 0, end = nums.length - 1;
            int media;
            while (start <= end) {
                media = (start + end) / 2;
                if (nums[media] == target) {
                    return media;
                }
                if (target > nums[media]) {
                    if (target >= anInt && nums[media] < anInt) {
                        end = media - 1;
                    } else {
                        start = media + 1;
                    }
                } else {
                    if (target < anInt && nums[media] >= anInt) {
                        start = media + 1;
                    } else {
                        end = media - 1;
                    }
                }
            }
            return -1;
        }
    }
}
