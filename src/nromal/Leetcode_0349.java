package nromal;

import java.util.*;

public class Leetcode_0349 {

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set_a = new HashSet<>();
            Set<Integer> set_b = new HashSet<>();
            List<Integer> result = new ArrayList<>();
            for (int i : nums1) {
                set_a.add(i);
            }

            for (int i : nums2) {
                set_b.add(i);
            }

            set_a.stream().forEach((a)->{if (set_b.contains(a)) {
                result.add(a);
            }
            });
            int[] ans = new int[result.size()];
            for (int i = 0; i < result.size(); ++i) {
                ans[i] = result.get(i);
            }
            return ans;
        }
    }

}
