package hot_100;

import java.util.*;

public class Hot_001 {

    public int[] sum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return  new int[]{};

    }

    public static void main(String[] args){
        int[] nums = {6, 3, 6, 3};
        int target = 12;
        Hot_001 test = new Hot_001();

        int[] results = test.sum(nums, target);
        for (int i: results)
            System.out.println(i);
    }
}
