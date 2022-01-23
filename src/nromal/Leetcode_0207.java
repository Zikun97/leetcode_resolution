package nromal;

public class Leetcode_0207 {


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p_a = headA;
            ListNode p_b = headB;
            boolean flag_a = true;
            boolean flag_b = true;
            while (p_a != p_b) {
                if (p_a.next == null && flag_a) {
                    p_a = headB;
                    flag_a = false;
                } else {
                    p_a = p_a.next;
                }
                if (p_b.next == null && flag_b) {
                    p_b = headA;
                    flag_b = false;
                } else {
                    p_b = p_b.next;
                }
            }
            return p_a;
        }
    }

}
