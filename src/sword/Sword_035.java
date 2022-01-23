package sword;

import javafx.beans.binding.IntegerBinding;

import java.util.HashMap;
import java.util.Map;

public class Sword_035 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /** 2021/6/1 仅超过13.31% */
    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null)
                return null;

            /** 2021/6/1 映射关系为 原node --> 整数 --> 新node，本质上可以化简为 原node --> 新node */
            Map<Node, Integer> src_map = new HashMap<>();
            Map<Integer, Node> dst_map = new HashMap<>();

            Node new_head = new Node(head.val);
            Node p = head;
            Node new_p = new_head;
            int count = 0;

            src_map.put(head, count);
            dst_map.put(count++, new_head);

            while (p.next != null) {
                new_p.next = new Node(p.next.val);
                p = p.next;
                new_p = new_p.next;
                src_map.put(p, count);
                dst_map.put(count++, new_p);
            }

            p = head;
            new_p = new_head;
            int idx = 0;
            if (p.random != null) {
                idx = src_map.get(p.random);
                new_p.random = dst_map.get(idx);
            }
            while (p.next != null) {
                p = p.next;
                new_p = new_p.next;
                if (p.random != null) {
                    idx = src_map.get(p.random);
                    new_p.random = dst_map.get(idx);
                }
            }
            return new_head;
        }
    }


    /*** 2021/6/1 哈希表法*/

    static class Solution_1 {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Map<Node, Node> map = new HashMap<>();
            // 需要一个头节点
            Node temp = head;
            while (temp != null) {
                map.put(temp, new Node(temp.val));
                temp = temp.next;
            }

            temp = head;
            while (true) {
                if (temp.random != null) {
                    map.get(temp).random = map.get(temp.random);
                }
                if (temp.next != null) {
                    map.get(temp).next = map.get(temp.next);
                    temp = temp.next;
                } else
                    break;
            }
            return map.get(head);
        }
    }

    /** 2021/6/2 拼接和拆分 时间复杂度：O(n) 空间复杂度：O(1)*/
    static class Solution_2 {
        public Node copyRandomList(Node head) {
            Node temp = head;
            Node p;
            while (temp != null) {
                p = temp.next;
                temp.next = new Node(temp.val);
                temp.next.next = p;
                temp = p;
            }
            temp = head;
            while (temp != null) {
                temp.next.random = temp.random.next;
                temp = temp.next.next;
            }

            Node new_head = head.next;
            temp = head;
            while (temp != null) {
                p = temp.next;
                temp.next = temp.next.next;
                if (p.next != null) {
                    p.next = p.next.next;
                }
                temp = temp.next;
            }

            return new_head;
        }
    }


}

