package sword;

import java.util.Stack;

public class Sword_009 {

    class CQueue {

        private boolean one = true;
        private Stack<Integer> a = new Stack<>();
        private Stack<Integer> b = new Stack<>();
        public CQueue() {
        }

        public void appendTail(int value) {
            if (!one){
                while (!b.isEmpty()) {
                    a.push(b.peek());
                    b.pop();
                }
                one = true;
            }
            a.push(value);

        }

        public int deleteHead() {
            int res = 0;
            if (one) {
                while (!a.isEmpty()){
                    b.push(a.peek());
                    a.pop();
                }
                one = false;
            }

            if (b.isEmpty())
                return -1;
            res = b.peek();
            b.pop();
            return res;
        }
    }

}
