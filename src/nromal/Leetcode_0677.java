package nromal;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_0677 {


    /***
     * 题目：键值映射
     */

    /**
     * 暴力解法
     * 暴力遍历即可
     */
    static class MapSum {

        private Map<String, Integer> map;
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum =0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().startsWith(prefix)) {
                    sum += entry.getValue();
                }
            }
            return sum;
        }
    }


    /**
     * 前缀树 + 哈希
     */
    static class MapSum0 {

        // 存储输入的键值对
        private Map<String, Integer> map = new HashMap<>();
        // 存储前缀键值对
        private Map<String, Integer> prefixMap = new HashMap<>();

        public MapSum0() {

        }

        public void insert(String key, int val) {
            // new值与old值的差距
            int delta = val - this.map.getOrDefault(key, 0);
            this.map.put(key, val);
            // 更新prefixMap
            for (int i = 1; i <= key.length(); ++i) {
                String prefix = key.substring(0, i);
                this.prefixMap.put(prefix, this.prefixMap.getOrDefault(prefix, 0) + delta);
            }
        }

        public int sum(String prefix) {
            return this.prefixMap.getOrDefault(prefix, 0);
        }
    }


    /**
     * 字典树
     */
    static class MapSum1 {

        class TrieNode {
            public int val;
            public TrieNode[] next = new TrieNode[26];

            public TrieNode() {}

            public TrieNode(int val) {
                this.val = val;
            }
        }

        private Map<String, Integer> map = new HashMap<>();
        private TrieNode root = new TrieNode();

        public MapSum1() {
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode node = this.root;
            for (char ch : key.toCharArray()) {
                int idx = ch - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new TrieNode(0);
                }
                node.next[idx].val += delta;
                node = node.next[idx];
            }
        }

        public int sum(String prefix) {
            int sum = 0;
            TrieNode node = this.root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.next[idx] == null) {
                    return 0;
                }
                sum = node.next[idx].val;
                node = node.next[idx];
            }
            return sum;
        }
    }

}
