package nromal;

import java.util.LinkedList;
import java.util.Stack;

public class Leetcode_0232 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    class MyQueue {

        private Stack<Integer> stack_a = new Stack<>();

        private Stack<Integer> stack_b = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            stack_a.push(x);
        }

        public int pop() {
            if (stack_b.empty()) {
                while (!stack_b.empty()) {
                    stack_b.add(stack_a.pop());
                }
            }
            return stack_b.pop();
        }

        public int peek() {
            if (stack_b.empty()) {
                while (!stack_a.empty()) {
                    stack_b.add(stack_a.pop());
                }
            }
            return stack_b.peek();
        }

        public boolean empty() {
            return stack_a.empty() && stack_b.empty();
        }
    }

}
