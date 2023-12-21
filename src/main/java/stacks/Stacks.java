package stacks;

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
}
