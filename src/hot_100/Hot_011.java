package hot_100;

public class Hot_011 {
    static public void main(String[] args) {
        Solution_01 solution = new Solution_01();
        int[] heights = {1, 2, 3, 4};
        int res = solution.maxArea(heights);
        System.out.println(res);

    }

    // TODO: 2021/3/21 暴力循环，会超时
    static class Solution {
        public int maxArea(int[] height) {
            int max = -1;
            for (int i = 0; i < height.length; ++i) {
                for(int j = i + 1; j < height.length; ++j){
                    int result = Math.min(height[i], height[j]) * (j - i);
                    if (result > max) {
                        max = result;
                    }
                }
            }
            return max;
        }
    }

    // TODO: 2021/3/21 双指针法 
    static class Solution_01 {
        public int maxArea(int[] height) {
            int max = -1;
            int start = 0, end = height.length - 1;
            while (start < end){
                int res = 0;
                if (height[start] > height[end]) {
                    res = height[end] * (end - start);
                    end --;
                } else {
                    res = height[start] * (end - start);
                    start ++;
                }

                if (res > max) {
                    max = res;
                }
            }
            return max;
        }
    }

}
