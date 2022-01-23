package sword;

public class Sword_022 {


    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    static class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {

            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < k; ++i) {
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

    }
}
