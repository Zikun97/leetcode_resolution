package sword;

public class Sword_018 {


    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    static class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val)
                return head.next;
            ListNode node = head;
            while (node.next.val != val) {
                node = node.next;
            }
            ListNode temp = node.next.next;
            node.next = temp;
            return head;
        }
    }
    
}
