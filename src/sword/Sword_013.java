package sword;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class Sword_013 {

    static class Solution {

        class ListNode{
            public int x;
            public int y;

            ListNode(){}

            ListNode(int x, int y) {
                this.x = x;
                this.y = y;
            }

        }
        public static Deque<ListNode> pairDeque = new LinkedList<>();

        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            pairDeque.clear();
            int counter = 0;
            if (isArrival(0, 0, k)) {
                pairDeque.push(new ListNode(0, 0));
                visited[0][0] = true;
                counter ++;
            }
            while (!pairDeque.isEmpty()) {
                ListNode node = pairDeque.getFirst();
                pairDeque.removeFirst();
                if (node.x - 1 >= 0 && !visited[node.x - 1][node.y] && isArrival(node.x - 1, node.y, k)) {
                    visited[node.x - 1][node.y] = true;
                    counter ++;
                    pairDeque.add(new ListNode(node.x - 1, node.y));
                }
                if (node.x + 1 < m && !visited[node.x + 1][node.y] && isArrival(node.x + 1, node.y, k)) {
                    visited[node.x + 1][node.y] = true;
                    counter ++;
                    pairDeque.add(new ListNode(node.x + 1, node.y));
                }
                if (node.y - 1 >= 0 && !visited[node.x][node.y - 1] && isArrival(node.x, node.y - 1, k)) {
                    visited[node.x][node.y - 1] = true;
                    counter ++;
                    pairDeque.add(new ListNode(node.x, node.y - 1));
                }
                if (node.y + 1 < n && !visited[node.x][node.y + 1] && isArrival(node.x, node.y + 1, k)) {
                    visited[node.x][node.y + 1] = true;
                    counter ++;
                    pairDeque.add(new ListNode(node.x, node.y + 1));
                }
            }
            return counter;
        }


        private boolean isArrival(int x, int y, int k) {
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            while (y > 0) {
                sum += y % 10;
                y /= 10;
            }
            return sum <= k;
        }
    }
}
