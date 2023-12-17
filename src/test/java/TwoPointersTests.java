import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import twoPointers.TwoPointers;

public class TwoPointersTests {
    @Test
    void isPalindromeTest() {
        String s = "aba";
        boolean out = TwoPointers.isPalindrome(s);
        Assertions.assertTrue(out);
    }
}
