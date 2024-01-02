package stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stacks {
    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Stack<Character> validClosingChars = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                validClosingChars.push(')');
            } else if (c == '[') {
                validClosingChars.push(']');
            } else if (c == '{') {
                validClosingChars.push('}');
            } else if (!validClosingChars.isEmpty() &&
                    validClosingChars.peek() == c) {
                validClosingChars.pop();
            } else {
                return false;
            }
        }
        return validClosingChars.isEmpty();
    }

    /**
     * 150. Evaluate Reverse Polish Notation
     *
     * @param tokens String array of integers and tokens; input is assumed valid
     * @return value of the expression
     * @implNote time is O(n), space is O(n)
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            switch (t) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> stack.push(-stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(t));
            }
        }
        return stack.peek();
    }

    /**
     * 155. Min Stack
     * <p>
     * all operations are O(1) time
     *
     * @implNote You could do this with 2 stacks, one
     * for the main order and one that tracks the min
     * values. Here, a simpler approach is a Node object
     * that tracks the min at the time the value was pushed
     * to the MinStack, so the logic for the min is tied to
     * each Node's creation.
     */
    public static class MinStack {
        Node head;

        public MinStack() {
        }

        public void push(int val) {
            if (head == null) head = new Node(val, null);
            else head = new Node(val, head);
        }

        public void pop() {
            head = head.prev;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private static class Node {
            int val;
            Node prev;
            int min;

            private Node(int val, Node prev) {
                this.val = val;
                this.prev = prev;
                this.min = prev != null ? Math.min(this.val, this.prev.min) : val;
            }
        }
    }
}
