package nromal;

import java.util.*;

public class Leetcode_0454 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(9);
        list.add(7);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            // 加入Set
            Map<Integer, Integer> set_a = new HashMap<>();

            for (int i : nums1) {
                for (int j : nums2) {
                    int temp = i + j;
                    if (set_a.containsKey(temp)) {
                        set_a.put(temp, set_a.get(temp) + 1);
                    } else {
                        set_a.put(temp, 1);
                    }
                }
            }

            int res = 0;
            for (int i : nums3) {
                for (int j : nums4) {
                    int temp = - j - i;
                    if (set_a.containsKey(temp)) {
                        res += set_a.get(temp);
                    }
                }
            }

            return res;
        }
    }
}
