package nromal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_0559 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            Deque<Node> list = new LinkedList<>();
            list.add(root);
            int deep = 0;
            while (!list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; ++i) {
                    Node node = list.pollFirst();
                    if (node.children != null) {
                        for (Node ele : node.children) {
                            list.addLast(ele);
                        }
                    }
                }
                ++deep;
            }
            return deep;
        }
    }
}
