package hot_100;

public class Hot_021 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(0, null);
        ListNode l2 = new ListNode(0, null);
        ListNode h1 = l1;
        ListNode h2 = l2;
        for (int i = 1; i < 4; ++i) {
            l1.next = new ListNode(i, null);
            l2.next = new ListNode(i * 2, null);
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode res = solution.mergeTwoLists(h1.next, h2.next);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(", ");
            res = res.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null)
                return l2;
            if (l2 == null) {
                return l1;
            }

            ListNode head = null;
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
            ListNode temp = head;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            }

            while (l1 != null) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }

            while (l2 != null) {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }


            return head;
        }
    }
}

