package sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Sword_052 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    /**
     * 自己的朴素做法，比较拉垮
     * 效率：14.58； 5
     */
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null)
                return null;
            Deque<ListNode> deque1 = new LinkedList<>();
            Deque<ListNode> deque2 = new LinkedList<>();
            ListNode temp = headA;
            while (temp != null) {
                deque1.add(temp);
                temp = temp.next;
            }
            temp = headB;
            while (temp != null) {
                deque2.add(temp);
                temp = temp.next;
            }
            temp = null;

            ListNode node1 = deque1.pollLast();
            ListNode node2 = deque2.pollLast();
            while (node1 == node2) {
                temp = node1;
                if (!deque1.isEmpty())
                    node1 = deque1.pollLast();
                else
                    node1 = null;
                if (!deque2.isEmpty())
                    node2 = deque2.pollLast();
                else
                    node2 = null;
            }
            return temp;
        }
    }

    /**
     * 双指针法：相遇的浪漫
     * 自己看完思想后实现的，代码很挫
     * 效率：25.88; 92.53
     */

    static class Solution_a {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null ||headB == null)
                return null;
            ListNode pt1 = headA, pt2= headB;
            boolean flag1 = true, flag2 = true;
            while (true) {
                if (pt1 != null &&pt1 == pt2)
                    return pt1;
                else if (pt1 == null || pt2 == null)
                    return null;
                if (pt1.next != null)
                    pt1 = pt1.next;
                else if (flag1)
                {
                    flag1 = false;
                    pt1 =  headB;
                } else
                    pt1 = null;
                if (pt2.next != null) {
                    pt2 = pt2.next;
                } else if (flag2){
                    flag2 = false;
                    pt2 = headA;
                } else
                    pt2 = null;
            }
        }
    }

    /**
     * 双指针：相遇的浪漫
     * 参考大佬的做法，优雅而简单~
     * 效率：100; 44.11
     */

    static class Solution_b {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pt1 = headA, pt2 = headB;
            while (pt1 != pt2) {
                pt1 = pt1 == null ? headB: pt1.next;
                pt2 = pt2 == null ? headA: pt2.next;
                // 这里需要解释一下，如果连个链子没有共同节点，会不会陷入死循环？
                // 这里巧妙运用null，来避免情况
                // 1 -> 2 -> 3
                // 4 -> 5 -> 6 -> 7
                // 1 -> 2 -> 3 -> null -> 4    -> 5 -> 6 -> 7 -> null
                // 4 -> 5 -> 6 -> 7    -> null -> 1 -> 2 -> 3 -> null
                // 太妙了，手下膝盖
            }

            return pt1;
        }
    }


}
