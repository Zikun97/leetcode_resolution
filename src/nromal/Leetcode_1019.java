package nromal;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetcode_1019 {

    static class Solution {
        public int[] nextLargerNodes(ListNode head) {
            int len = 0;
            Map<Integer, Integer> result = new HashMap<>();
            ListNode node = head;
            Deque<Integer> indices = new LinkedList<>();
            Deque<Integer> values = new LinkedList<>();
            while (node != null) {

                while (!values.isEmpty() && node.val > values.getLast()) {
                    result.put(indices.getLast(), values.getLast());
                    values.removeLast();
                    values.removeLast();
                }
                indices.addLast(len++);
                values.add(node.val);
                node = node.next;
            }
            int[] nums = new int[len];
            for (Map.Entry<Integer, Integer> set : result.entrySet()) {
                nums[set.getKey()] = set.getValue();
            }
            return nums;
        }
    }
}
