package nromal;

import java.util.*;

public class Leetcode_0347 {

    public static void main(String[] args) {
        System.out.println(3 + 4 >> 1 );
    }


    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            int[] res = new int[k];
            for (int i = 0; i < k; ++i) {
                res[i] = list.get(i)[0];
            }
            return res;
        }
    }
}
