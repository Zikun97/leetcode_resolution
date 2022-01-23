package sword;

public class Sword_025 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // l1 作为合并链表
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            if (l1.val > l2.val) {
                return mergeTwoLists(l2, l1);
            }
            ListNode l1_temp = l1;
            ListNode l2_temp = l2;
            ListNode temp2, temp1;
            while (l1_temp.next != null && l2_temp.next != null) {
                if (l1_temp.val <= l2_temp.val && l1_temp.next.val > l2_temp.val) {
                    temp2 = l2_temp;
                    temp1 = l1_temp.next;
                    l2_temp = l2_temp.next;
                    l1_temp.next = temp2;
                    temp2.next = temp1;
                }
                l1_temp = l1_temp.next;
            }
            boolean flag = true;
            if (l1_temp.next == null) {
                l1_temp.next = l2_temp;
                flag =false;
            }
            if (l2_temp.next == null) {
                while (l1_temp.next != null) {
                    if (l1_temp.val <= l2_temp.val && l1_temp.next.val > l2_temp.val) {
                        temp1 = l1_temp.next;
                        l1_temp.next = l2_temp;
                        l2_temp.next = temp1;
                        flag =false;
                        break;
                    }
                    l1_temp = l1_temp.next;
                }
            }
            if (flag) {
                l1_temp.next = l2_temp;
            }
            return l1;
        }
    }


     static class ListNode {
        int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

}
