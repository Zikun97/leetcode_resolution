package sword;

public class Sword23 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp_0;
            ListNode temp_1 = head;
            ListNode head_new = head.next;
            while (head_new.next != null) {
                temp_0 = temp_1;
                temp_1 = head_new;
                head_new = head_new.next;
                temp_1.next = temp_0;
            }
            head.next = null;
            head_new.next = temp_1;
            return head_new;
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
