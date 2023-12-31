import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stacks.Stacks;

public class StacksTests {
    @Test
    void isValidTest() {
        String s = "[{}()]";
        boolean validString = Stacks.isValid(s);
        Assertions.assertTrue(validString);
    }

    @Test
    void minStackTest() {
        Stacks.MinStack minStack = new Stacks.MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        Assertions.assertEquals(0, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(0, minStack.getMin());
    }

    @Test
    void rpnTest() {
        String[] in = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int expected = 22;
        int out = Stacks.evalRPN(in);
        Assertions.assertEquals(expected, out);
    }
}
