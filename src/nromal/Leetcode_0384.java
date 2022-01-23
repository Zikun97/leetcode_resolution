package nromal;

import java.util.Arrays;
import java.util.Random;

public class Leetcode_0384 {

    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            System.out.println(random.nextInt(1));
        }
    }

    class Solution {

        private int[] _nums;
        private int[] _origins;
        private Random random = new Random();

        public Solution(int[] nums) {
            this._nums = nums;
            this._origins = new int[nums.length];
            System.arraycopy(this._nums, 0, this._origins, 0, this._nums.length);
        }

        public int[] reset() {
            System.arraycopy(this._origins, 0, this._nums, 0, this._nums.length);
            return this._nums;
        }

        public int[] shuffle() {
            for (int i = 0; i < this._nums.length; ++i) {
                int idx = i + random.nextInt(this._nums.length - i);
                int temp = this._nums[i];
                this._nums[i] = this._nums[idx];
                this._nums[idx] = temp;
            }
            return this._nums;
        }
    }
}
