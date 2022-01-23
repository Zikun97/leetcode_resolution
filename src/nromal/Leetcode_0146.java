package nromal;

import sun.awt.geom.AreaOp;

import java.util.*;

public class Leetcode_0146 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    static class LRUCache {

        class Node{
            int key = -1;
            int value;
            Node preNode;
            Node nextNode;
        }

        private int capacity;
        private Map<Integer, Node> map; // 结点map
        private Node root; // 存储头
        private Node tail; // 存储尾部，也就是可能要淘汰的结点
        public LRUCache(int capacity) {
            this.root = new Node();
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.tail = this.root;
        }

        public int get(int key) {
            if (this.map.containsKey(key)) {
                Node node = this.map.get(key);
                if (root.nextNode != node) {
                    // 保证原来位置的正确性
                    if (tail == node) {
                        tail = tail.preNode;
                        tail.nextNode = null;
                    } else {
                        node.preNode.nextNode = node.nextNode;
                        node.nextNode.preNode = node.preNode;
                    }
                    // 插入至next
                    node.nextNode = root.nextNode;
                    node.preNode = root;
                    if (node.nextNode != null) {
                        node.nextNode.preNode =  node;
                    }
                    root.nextNode = node;
                }

                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            // 如果key存在，则改变key值，并将结点移动到最前面
            if (this.map.containsKey(key)) {
                Node node = this.map.get(key);
                node.value = value;
                if (root.nextNode != node) {
                    // 保证原来位置的正确性
                    if (tail == node) {
                        tail = tail.preNode;
                        tail.nextNode = null;
                    } else {
                        node.preNode.nextNode = node.nextNode;
                        node.nextNode.preNode = node.preNode;
                    }
                    // 插入至next
                    node.nextNode = root.nextNode;
                    node.preNode = root;
                    if (node.nextNode != null) {
                        node.nextNode.preNode =  node;
                    }
                    root.nextNode = node;
                }
                return;
            }
            // 容量已经满了
            if (map.size() == this.capacity) {
                map.remove(tail.key);
                tail = tail.preNode;
                tail.nextNode = null;
            }
            Node node = new Node();
            node.key = key;
            node.value = value;

            // 直接插入最前面
            node.nextNode = root.nextNode;
            node.preNode = root;
            if (root.nextNode != null) {
                root.nextNode.preNode = node;
            }
            root.nextNode = node;
        }
    }
}
