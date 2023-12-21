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
}
