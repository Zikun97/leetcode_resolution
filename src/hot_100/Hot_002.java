package hot_100;

import java.util.Set;

public class Hot_002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode temp = l2;
        for (int i = 0; i < 4; ++i) {
            temp.next = new ListNode(9);
            temp = temp.next;

        }
        Solution solution = new Solution();

        ListNode res = solution.addTwoNumbers(l1, l2);
        temp = res;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }

    static class Solution{

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null){
                return l1;
            }
            int val = l1.val + l2.val;
            int single = 0;
            if (val > 9) {
                val = val % 10;
                single = 1;
            }

            ListNode result = new ListNode(val);
            ListNode pr = result;
            l1 = l1.next;
            l2 = l2.next;

            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    if (single == 0) {
                        pr.next = l2;
                        return result;
                    } else {
                        val = l2.val + single;
                        single = 0;
                        if (val > 9) {
                            val = val % 10;
                            single = 1;
                        }
                        pr.next = new ListNode(val);
                        pr = pr.next;
                        l2 = l2.next;
                        continue;
                    }

                }
                if (l2 == null) {
                    ListNode temp = l1;
                    l1 = l2;
                    l2 = temp;
                    continue;
                }

                val = l1.val + l2.val + single;
                single = 0;
                if (val > 9) {
                    val = val % 10;
                    single = 1;
                }
                pr.next = new ListNode(val);
                pr = pr.next;

                l1 = l1.next;
                l2 = l2.next;
            }
            if (single != 0) {
                pr.next = new ListNode(single);
            }
            return result;
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



