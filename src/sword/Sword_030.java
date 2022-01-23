package sword;

import java.util.LinkedList;

public class Sword_030 {


    static class MinStack {
        private LinkedList<Integer> list;
        private LinkedList<MinValue> minList;
        /** initialize your data structure here. */
        public MinStack() {
            this.list = new LinkedList<>();
            this.minList = new LinkedList<>();
        }

        public void push(int x) {
            this.list.add(x);
            if (this.minList.isEmpty() || this.minList.getLast().value > x) {
                this.minList.add(new MinValue(this.list.size(), x));
            }
        }

        public void pop() {
            if (this.list.isEmpty())
                return;
            if (this.minList.getLast().index == this.list.size()) {
                this.minList.removeLast();
            }
            this.list.removeLast();

        }

        public int top() {
            return this.list.getLast();
        }

        public int min() {
            return  this.minList.getLast().value;
        }

        class MinValue {
            private int index;
            private int value;
            public MinValue(int index, int value){
                this.index = index;
                this.value = value;
            }
        }

    }

}
