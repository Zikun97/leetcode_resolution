package nromal;

import com.sun.org.apache.xerces.internal.impl.dv.xs.SchemaDVFactoryImpl;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_0590 {

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


    /***
     * 迭代版本
     */
    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> results = new ArrayList<>();
            if (root == null) {
                return results;
            }
            Deque<Node> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Node cur = stack.getLast();
                if (cur == null) {
                    stack.removeLast();
                    cur = stack.removeLast();
                    results.add(cur.val);
                    continue;
                }
                if (cur.children != null) {
                    stack.add(null);
                    for (int i = cur.children.size() - 1; i >= 0; --i) {
                        stack.addLast(cur.children.get(i));
                    }
                } else {
                    results.add(cur.val);
                    stack.removeLast();
                }
            }
            return results;
        }
    }


    /**
     * 递归版本
     */
    static class Solution_0 {
        private List<Integer> results = new ArrayList<>();
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return results;
            }
            dfs(root);
            return results;
        }

        private void dfs(Node root) {
            if (root.children != null) {
                for (int i = root.children.size() - 1; i >= 0; --i) {
                    dfs(root.children.get(0));
                }
            }
            results.add(root.val);
        }
    }

}
