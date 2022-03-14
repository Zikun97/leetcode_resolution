package nromal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

public class Leetcode_0589 {

    class Solution {
        public List<Integer> preorder(Node root) {
            Deque<Node> nodes = new LinkedList<>();
            List<Integer> results = new ArrayList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                Node temp = nodes.pollFirst();
                results.add(temp.val);
                if (temp.children != null) {
                    for (int i = temp.children.size() - 1; i >= 0; --i) {
                        nodes.addFirst(temp.children.get(i));
                    }
                }
            }
            return results;
        }
    }
}
