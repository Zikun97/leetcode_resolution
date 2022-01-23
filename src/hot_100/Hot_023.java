package hot_100;

import org.w3c.dom.NodeList;

public class Hot_023 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = setList(new int[]{-10, -9, -9, -3, -1, -1, 0});
        ListNode l2 = setList(new int[]{-5});
        ListNode l3 = setList(new int[]{4});
        ListNode l4 = setList(new int[]{-8});
        ListNode l5 = setList(new int[]{});
        ListNode l6 = setList(new int[]{-9, -6, -5, -4, -2, 2, 3});
        ListNode l7 = setList(new int[]{-3, -3, -2, -1, 0});
        ListNode[] m = {l1, l2, l3, l4, l5, l6, l7};
        ListNode h1 = setList(new int[]{-9, -8, -6, -5, -5, -4, -3, -3, -3, -2, -2, -1, -1, -1, 0, 0, 2, 3, 4,});
        ListNode h2 = setList(new int[]{-10, -9, -9, -8, -6, -5, -5, -4, -3, -2, -1, -1, 0, 2, 3, 4, });


        ListNode res = solution.mergeKLists(m);
//        ListNode res = solution.mergeTwoLists(h1, h2);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(", ");
            res = res.next;
        }

//        int m = 2;
//        System.out.println( 2  + (m >> 1));

    }

    static public ListNode setList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;

        for (int i = 1; i < nums.length; ++i) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return head;
    }







    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0)
                return null;
            for (int i = 1; i <=lists.length; i <<= 1) {
                for (int j = 0; j < lists.length; j += i << 1) {
                    if ((j + i < lists.length)) {
                        lists[j] = mergeTwoLists(lists[j], lists[j + i]);
                        System.out.println("lists[" + j + "]");
                        showList(lists[j]);
                   }
                }
            }


            return lists[0];

        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            ListNode head = new ListNode(0, null);
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

            temp.next = l1 == null ? l2: l1;
            return head.next;
        }


        public void showList(ListNode l1) {
            if (l1 == null) {
                System.out.println("null");
                return;
            }

            while (l1 != null) {
                System.out.print(l1.val);
                System.out.print(", ");
                l1 = l1.next;
            }
            System.out.println();
        }


    }
}

