import binarySearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTests {
    @Test
    void binarySearchTest() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int output = BinarySearch.search(nums, target);
        int expected = 4;
        Assertions.assertEquals(expected, output);
    }
}
