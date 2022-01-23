package nromal;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Leetcode_0239 {


    /**
     * 使用优先队列：
     * 注意点：不是每一次移动窗口都要删除之前的节点，当头节点不是自己的节点时，再删除
     */
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] == o1[0] ? o2[1] - o1[1]: o2[0] - o1[0];
                }
            });
            int[] ans = new int[nums.length - k + 1];
            for (int i = 0; i < k; ++i) {
                queue.add(new int[]{nums[i], i});
            }
            int idx = 0;
            ans[idx++] = queue.peek()[0];

            for (int i = k; i < nums.length; ++i) {
                queue.add(new int[]{nums[i], i});
                while (queue.peek()[1] <= i - k) {
                    queue.remove();
                }
                ans[idx++] = queue.peek()[0];

            }


            return ans;
        }
    }


    static class Solution_a {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < k; ++i) {
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            int[] ans = new int[nums.length - k + 1];
            int idx = 0;
            ans[idx++] = nums[deque.peekFirst()];
            for (int i = k; i < nums.length; ++i) {
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.removeFirst();
                }

                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.addLast(i);

                ans[idx++] = nums[deque.peekFirst()];
            }
            return ans;
        }
    }

}
