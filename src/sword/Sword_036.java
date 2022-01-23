package sword;

import javax.management.StandardEmitterMBean;

public class Sword_036 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    static class Solution {

        Node head;
        Node tail;
        boolean needHead = true;
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;

            getList(root);
            Node temp = tail;
            while (temp.left != null) {
                temp.left.right = temp;
                temp = temp.left;

            }
            head.left = tail;
            tail.right = head;
            return head;
        }

        private void getList(Node root) {
            // 先左节点
            if (root.left != null) {
                getList(root.left);
            }
            // 然后父节点
            if (needHead) {
                head = root;
                tail = root;
                needHead = false;
            } else {
                root.left = tail;
                tail = root;
            }

            // 最后右节点
            if (root.right != null)
                getList(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);

        Solution solution = new Solution();
        Node head = solution.treeToDoublyList(root);
        Node temp = head;
        while (temp!=head.left) {
            System.out.println(temp.val);
            temp = temp.right;
        }
    }

}
