package nromal;

import java.util.Random;

public class Leetcode_0382 {

    class Solution {

        private ListNode head;
        private Random random = new Random();
        private int size = 0;

        public Solution(ListNode head) {
            this.head = head;
            ListNode node = head;
            while (head != null) {
                ++size;
                node = node.next;
            }
        }

        public int getRandom() {
            int rand = this.random.nextInt(this.size);
            ListNode temp = this.head;
            while (rand > 0) {
                temp = temp.next;
                --rand;
            }
            return temp.val;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
