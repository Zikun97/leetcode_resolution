package hot_100;

public class Hot_019 {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode false_head = new ListNode(0, head);
            ListNode fast = false_head;
            ListNode slow = false_head;
            for (int i = 0; i < n; ++i) {
                    fast = fast.next;
            }

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            fast = slow;
            fast.next = slow.next.next;

            return false_head.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

