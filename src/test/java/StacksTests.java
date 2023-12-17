import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stacks.Stacks;

import java.util.*;

public class StacksTests {
    @Test
    void isValidTest() {
        String s = "[{}()]";
        boolean validString = Stacks.isValid(s);
        Assertions.assertTrue(validString);
    }
}
