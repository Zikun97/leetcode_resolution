package sword;

import java.util.Arrays;

public class Sword_045 {

    public static void main(String[] args) {
        Solution_a solution = new Solution_a();
        int[] nums = {824,938,1399,5607,6973,5703,9609,4398,8247};
//        int[] nums = {121, 12};
//        "1399, 4398, 5607, 5703, 6973, 824, 8247, 938, 9609"
//        "1399, 4398, 5607, 5703, 6973, 8247, 824, 938, 9609"
        System.out.println(solution.minNumber(nums));
//        System.out.println(solution.more(8244, 824));
//        solution.sort(nums, 0, nums.length - 1);
//        for (int i : nums) {
//            System.out.println(i);
//        }
    }


    /**
     * 自己粗浅的想法（ 其实也不是那么粗浅，可是还是想不到比较方法）
     *
     */
    static class Solution {
        public String minNumber(int[] nums) {
            if (nums.length == 0) {
                return "";
            }
            sort(nums, 0, nums.length - 1);
            StringBuilder sb = new StringBuilder();
            for (int ele : nums) {
                sb.append(ele);
            }
            return sb.toString();
        }

        public void sort(int[] nums, int start, int end) {
            if (start >= end)
                return;
            int pivotKey = nums[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && more(nums[j], pivotKey)) j--;
                if (i < j) nums[i] = nums[j];
                while (i < j && more(pivotKey, nums[i])) i++;
                if (i < j) nums[j] = nums[i];
            }
            nums[i] = pivotKey;
            sort(nums, start, i - 1);
            sort(nums, i + 1, end);
        }

        // 把此题比较想象成简单的字符串比较问题，怎么改都wrong
        // 自闭了，看题解了
        public boolean more(int x, int y) {
            char[] x_str = String.valueOf(x).toCharArray();
            char[] y_str = String.valueOf(y).toCharArray();
            int idx = 0;
            while (idx < x_str.length && idx < y_str.length) {
                if (x_str[idx] > y_str[idx]) {
                    return true;
                } else if (x_str[idx] < y_str[idx]) {
                    return false;
                } else {
                    ++idx;
                }
            }
            if (idx < x_str.length) {
                return x_str[idx] > x_str[0];
            } else if (idx < y_str.length) {
                return y_str[idx] <= y_str[0];
            }
            return true;
        }
    }


    /**
     * K神的做法： x "+" y > y "+" x, 则x > y
     * 效率： 55.88; 59.04
     */
    static class Solution_a {
        public String minNumber(int[] nums) {
            String[] strings = new String[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                strings[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder sb = new StringBuilder();
            for (String ele : strings) {
                sb.append(ele);
            }
            return sb.toString();
        }
    }


    /**
     * 快排版本：速度更快！
     * 效率： 97.26; 92.32
     */
    class Solution_b {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            quickSort(strs, 0, strs.length - 1);
            StringBuilder res = new StringBuilder();
            for(String s : strs)
                res.append(s);
            return res.toString();
        }
        void quickSort(String[] strs, int l, int r) {
            if(l >= r) return;
            int i = l, j = r;
            String tmp = strs[i];
            while(i < j) {
                while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
                while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
                tmp = strs[i];
                strs[i] = strs[j];
                strs[j] = tmp;
            }
            strs[i] = strs[l];
            strs[l] = tmp;
            quickSort(strs, l, i - 1);
            quickSort(strs, i + 1, r);
        }
    }


}
