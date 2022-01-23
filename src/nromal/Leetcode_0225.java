package nromal;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_0225 {

    class MyStack {

        private List<Integer> list_a = new ArrayList<>();
        private List<Integer> list_b = new ArrayList<>();
        private boolean flag = true;
        public MyStack() {
        }

        public void push(int x) {
            if (flag) {
                list_a.add(x);
            } else {
                list_b.add(x);
            }
        }

        public int pop() {
            int res;
            if (flag) {
                while (list_a.size() > 1) {
                    list_b.add(list_a.get(0));
                    list_a.remove(0);
                }
                flag =  false;
                res = list_a.get(0);
                list_a.remove(0);
            } else {
                while (list_b.size() > 1) {
                    list_a.add(list_b.get(0));
                    list_b.remove(0);
                }
                flag = true;
                res = list_b.get(0);
                list_b.remove(0);
            }
            return res;
        }

        public int top() {
            int res;
            if (flag) {
                while (list_a.size() > 1) {
                    list_b.add(list_a.get(0));
                    list_a.remove(0);
                }
                flag =  false;
                res = list_a.get(0);
                list_a.remove(0);
                list_b.add(res);
            } else {
                while (list_b.size() > 1) {
                    list_a.add(list_b.get(0));
                    list_b.remove(0);
                }
                flag = true;
                res = list_b.get(0);
                list_b.remove(0);
                list_a.add(res);
            }
            return res;
        }

        public boolean empty() {
            return list_a.isEmpty() && list_b.isEmpty();
        }
    }
}
