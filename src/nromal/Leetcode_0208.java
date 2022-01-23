package nromal;

public class Leetcode_0208 {

    /**
     * 题目： 实现字典树（前缀树）
     */

    class Trie {

        private Node root;

        class Node {
            Node[] next = new Node[26];
            boolean isEnd = false;

            public Node() {
            }

        }

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node temp = root;
            int idx = 0;
            for (int i = 0; i < word.length(); ++i) {
                idx = word.charAt(i) - 'a';
                if (temp.next[idx] == null) {
                    temp.next[idx] = new Node();
                }
                temp = temp.next[idx];
            }
            temp.isEnd = true;
        }

        public boolean search(String word) {
            Node temp = root;
            int idx = 0;
            for (int i = 0; i < word.length(); ++i) {
                idx = word.charAt(idx) - 'a';
                if (temp.next[idx] == null) {
                    return false;
                }
                temp = temp.next[idx];
            }
            return temp.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node temp = root;
            int idx = 0;
            for (int i = 0; i < prefix.length(); ++i) {
                idx = prefix.charAt(idx) - 'a';
                if (temp.next[idx] == null) {
                    return false;
                }
                temp = temp.next[idx];
            }
            return true;
        }
    }
}
